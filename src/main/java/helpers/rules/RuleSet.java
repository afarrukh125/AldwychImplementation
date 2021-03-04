package helpers.rules;

import helpers.ValueTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class RuleSet implements Iterable<Rule> {
    private final List<Rule> rules;

    public RuleSet() {
        rules = new ArrayList<>();
    }

    public static Rule from(Ask ask, Tell tell) {
        return new RegularRule(ask, tell);
    }

    public static Rule from(Tell tell) {
        return new FinalRule(tell);
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    @Override
    public Iterator<Rule> iterator() {
        return rules.iterator();
    }

    /**
     * Runs all the rules in turn and returns the rule that had the correct tell and ask
     */
    public RuleData executeAll(ValueTable valueTable, Rule finalRule) {
        int numRules = rules.size();

        // Each rule to be executed concurrently
        ExecutorService executorService = Executors.newFixedThreadPool(numRules);
        CompletionService<RuleData> completionService = new ExecutorCompletionService<>(executorService);

        for (Rule rule : rules)
            completionService.submit(() -> rule.execute(valueTable));


        int receivedCount = 0;
        RuleData ruleData = null;
        // Try until we find that we have executed all the main rules, or we have found that none of the rules apply
        while (!executorService.isTerminated() && receivedCount < numRules) {
            try {
                Future<RuleData> resultFuture = completionService.take();
                RuleData obtainedRule = resultFuture.get();
                if (obtainedRule != null) {
                    ruleData = obtainedRule;
                    executorService.shutdownNow();
                }
                receivedCount++;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // This is the situation where we use the final rule, the "all-else-fails" rule
        // where none of the regular rules applied
        if (ruleData == null) {
            if (!executorService.isTerminated())
                executorService.shutdownNow();
            return finalRule.execute(valueTable);
        }

        return ruleData;
    }
}
