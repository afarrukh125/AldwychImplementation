package helpers;

/**
 * Flags to be used by visitors to adhere to preferred language semantics
 * An example use of this is the equals symbol (=)
 * In the context of an ask, this symbol is used for comparison, and in the context of a tell, this is used for assignment
 */
public enum Flag {

    EQ_SET,
    ID_ONLY

}
