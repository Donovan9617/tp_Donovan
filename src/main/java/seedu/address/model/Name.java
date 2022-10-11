package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the name of the client. This class is modelled after the Name class in the Person package of AB3
 */
public class Name {

    public static final String MESSAGE_CONSTRAINTS =
            "Names should not be blank and can contain only contain alphanumeric characters and spaces. A name may "
                    + "contain at most"
                    + " "
                    + "3 words and each word can be at most 10 characters long.";


    /**
     * The name can contain only letters and spaces.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    private String fullName;

    /**
     * Constructs a Name.
     *
     * @param name A valid name.
     */
    public Name(String name) {
        requireNonNull(name);
        checkArgument(isValidName(name), MESSAGE_CONSTRAINTS);
        fullName = name;
    }

    /**
     * Represents an Empty Name.
     */
    private static class EmptyClientName extends Name {
        private static final Name EMPTY_NAME = new EmptyClientName();
        private EmptyClientName() {
            super("");
        }

        /**
         * Checks if this Client Name is empty.
         * @return true if the Client Name is empty.
         */
        @Override
        public boolean isEmpty() {
            return true;
        }
    }


    /**
     * Returns true if a given string is a valid name. A name is valid only if it contains oly letters and spaces and
     * had a maximum of three words, each of length less than 10 characters.
     * @param test String representing name to be tested
     * @return boolean true if a given string is a valid name
     */
    public static boolean isValidName(String test) {

        String[] words = test.split(" ");
        boolean hasCorrectWordCount = words.length > 0 && words.length <= 3;
        boolean hasCorrectWordFormat = isValidWordArray(words);
        return !test.isEmpty() && hasCorrectWordFormat && hasCorrectWordCount;
    }


    /**
     * Returns true if a given array of strings are valid words in a name. A word is valid only if it is at most 10
     * characters
     * long.
     * @param words Array of strings representing words to be tested
     * @return boolean true if the words are valid
     */
    public static boolean isValidWordArray(String[] words) {
        boolean isValid = true;
        for (String s : words) {
            isValid = isValid && s.length() <= 10 && s.matches(VALIDATION_REGEX);
        }
        return isValid;
    }

    /**
     * Checks if this Client Name is empty.
     * @return true if the Client Name is empty.
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the full name of the client.
     * @return String representing full name
     */
    public String getFullNameRepresentation() {
        return this.fullName;
    }

    /**
     * Returns the String representation of the Client Name.
     * @return String representing the Client Name
     */
    @Override
    public String toString() {
        return this.fullName;
    }

    /**
     * Checks if an object equals this.
     * @param other Object to be checked
     * @return boolean true if this is equal to other and false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;

        } else if (other instanceof Name) {
            Name otherName = (Name) other;
            return this.fullName.equals(otherName.fullName);

        } else {
            return false;
        }
    }

}