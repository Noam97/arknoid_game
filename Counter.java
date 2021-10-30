/**
 * A Counter class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-03
 */
public class Counter {
    private  int value;

    /**
     * constructor.
     * @param val value
     */
    public Counter(int val) {
        this.value = val;
    }

    /**
     *constructor.
     */
    public Counter() {
        this.value = 0;
    }
    /**
     *  add number to current count.
     * @param number number to add to current count
     */
   public void increase(int number) {
        this.value += number;
   }

    /**
     * subtract number from current count.
     * @param number number to subtract
     */
   public void decrease(int number) {
       this.value -= number;
   }

    /**
     *
     * @return current count.
     */
   public int getValue() {
        return this.value;
   }
}
