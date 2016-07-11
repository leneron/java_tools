package tools.worm;

import java.util.Objects;

/**
 * Created by tetyana.kolodyazhna on 06.07.16.
 *
 * Write once, read many class
 * Lazy initialization for final variable:
 * http://stackoverflow.com/questions/11583502/
 * */

    public class Worm<T> {
        private volatile Wrapper<T> wrapper;

        public Worm() {}
        public Worm(T data) throws IllegalAccessError
        {
            setData(data);
        }

        public T getData()
        {
            if (wrapper == null)
                return null;
            return wrapper.data;
        }

        public void setData(T data) throws IllegalAccessError
        {
            if (wrapper != null)
                throw new IllegalAccessError();
            else
                wrapper = this.new Wrapper<>(data);
        }

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
            final Worm<T> other = (Worm<T>) obj;
            return Objects.equals(this.getData(), other.getData());
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.getData());
        }

        final private class Wrapper<T> {
            final private T data;

            Wrapper(T data) {
                this.data = data;
            }
        }
    }
