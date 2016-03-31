//package bingyue.jdknotes;
///**
// * 所有类的超类
// */
//public class Object {
//    private static native void registerNatives();
//    static {
//        registerNatives();
//    }
//    /**
//     * 创建并返回此对象的副本。
//     * “复制”的准确含义可能根据对象的不同有变化。
//     * Returns the runtime class of this Object. 
//     * The returned Class object is the object that is locked by 
//     * "static""synchronized" methods of the represented class.
//     */
//    public final native Class<?> getClass();
//    
//    /**
//     * 1.在 Java 应用程序执行期间，在对同一对象多次调用 hashCode 方法时，必须一致地返回相同的整数，
//     * 前提是将对象进行 equals 比较时所用的信息没有被修改。从某一应用程序的一次执行到同一应用程序的另一次执行，该整数无需保持一致。  
//     * 2.如果根据 equals(Object) 方法，两个对象是相等的，那么对这两个对象中的每个对象调用 hashCode 方法都必须生成相同的整数结果。  
//     * 3.如果根据 equals(java.lang.Object) 方法，两个对象不相等，那么对这两个对象中的任一对象上调用 hashCode方法不 要求一定生成不同的整数结果
//     * 但是，程序员应该意识到，为不相等的对象生成不同整数结果可以提高哈希表的性能。 
//     */
//    public native int hashCode();
//    public boolean equals(Object obj) {
//        return (this == obj);
//    }
//
//    protected native Object clone() throws CloneNotSupportedException;
//    
//    /**
//     * 返回该对象的字符串表示
//     */
//    public String toString() {
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
//    }
//
//    public final native void notify();
//    public final native void notifyAll();
//    public final native void wait(long timeout) throws InterruptedException;
//
//    public final void wait(long timeout, int nanos) throws InterruptedException {
//        if (timeout < 0) {
//            throw new IllegalArgumentException("timeout value is negative");
//        }
//        if (nanos < 0 || nanos > 999999) {
//            throw new IllegalArgumentException(
//                                "nanosecond timeout value out of range");
//        }
//        if (nanos >= 500000 || (nanos != 0 && timeout == 0)) {
//            timeout++;
//        }
//        wait(timeout);
//    }
//    public final void wait() throws InterruptedException {
//        wait(0);
//    }
//    /**
//     * 当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法
//     * Called by the garbage collector on an object when garbage collection
//     * determines that there are no more references to the object.
//     */
//    protected void finalize() throws Throwable { }
//}
