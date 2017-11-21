package core.java;

/**
 *
 * @author eric
 */
public enum Colors {
    
    RED {
        @Override
        public int getRed() {
            return 100;
        }

        @Override
        public int getGreen() {
            return 0;
        }

        @Override
        public int getBlue() {
            return 0;
        }
    },
    BLUE {
        @Override
        public int getRed() {
            return 0;
        }

        @Override
        public int getGreen() {
            return 0;
        }

        @Override
        public int getBlue() {
            return 100;
        }
    };
    
    public abstract int getRed();
    public abstract int getGreen();
    public abstract int getBlue();
    
}
