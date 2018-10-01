package demo;


/**
 * Entity to hold number from a JSON model
 */
public final class SpecialNumberEntity {

    private String number;


    private SpecialNumberEntity() {

    }

    private SpecialNumberEntity(String number) {
        this.number = number;
    }

    /**
     * Get the number
     *
     * @return number
     */
    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int primeNumber = 37;
        int result = 1;
        result = primeNumber * result + ((number == null) ? 0 : number.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SpecialNumberEntity other = (SpecialNumberEntity) obj;
        if (number == null) {
            return other.number == null;
        } else return number.equals(other.number);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SpecialNumberEntity [number=" + number + "]";
    }

}