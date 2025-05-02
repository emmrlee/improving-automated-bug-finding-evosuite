// Group 3

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.objectweb.asm.Type;

public class WeirdCasePool implements ConstantPool {
    private final Set<String> stringPool = Collections.synchronizedSet(new LinkedHashSet<>());
    // [EMMA] Do we need this typePool?
    private final Set<Type> typePool = Collections.synchronizedSet(new LinkedHashSet<>());
    private final Set<Integer> intPool = Collections.synchronizedSet(new LinkedHashSet<>());
    private final Set<Double> doublePool = Collections.synchronizedSet(new LinkedHashSet<>());
    private final Set<Long> longPool = Collections.synchronizedSet(new LinkedHashSet<>());
    private final Set<Float> floatPool = Collections.synchronizedSet(new LinkedHashSet<>());

    public WeirdCasePool() {
        /*
		 * all pools HAVE to be non-empty 
		 */

        // [EMMA] LLM will generate weird cases, so we need to add them to the pool
		// stringPool.add("");

		// if (Properties.TARGET_CLASS != null && !Properties.TARGET_CLASS.isEmpty()) {
		// 	typePool.add(Type.getObjectType(Properties.TARGET_CLASS));
		// } else {
		// 	typePool.add(Type.getType(Object.class));
		// }

		// intPool.add(0);
		// intPool.add(1);
		// intPool.add(-1);

		// longPool.add(0L);
		// longPool.add(1L);
		// longPool.add(-1L);

		// floatPool.add(0.0f);
		// floatPool.add(1.0f);
		// floatPool.add(-1.0f);

		// doublePool.add(0.0);
		// doublePool.add(1.0);
		// doublePool.add(-1.0);
    }
    
    // Implement required methods
    @Override
    public String getRandomString() {
        return Randomness.choice(stringPool);
    }
    
    @Override
    public Type getRandomType() {
        return Randomness.choice(typePool);
    }
    
    @Override
    public int getRandomInt() {
        return Randomness.choice(intPool);
    }
    
    @Override
    public double getRandomDouble() {
        return Randomness.choice(doublePool);
    }
    
    @Override
    public long getRandomLong() {
        return Randomness.choice(longPool);
    }
    
    @Override
    public float getRandomFloat() {
        return Randomness.choice(floatPool);
    }
    
    @Override
    public void add(Object object) {
        // We don't add null because this is explicitly handled in the TestFactory
		if (object == null)
			return;

		if (object instanceof String) {
			String string = (String) object;
			if(string.length() > Properties.MAX_STRING)
				return;
			// String literals are constrained to 65535 bytes 
			// as they are stored in the constant pool
			if (string.length() > 65535)
				return;
			stringPool.add(string);
		} else if (object instanceof Type) {
			while (((Type) object).getSort() == Type.ARRAY) {
				object = ((Type) object).getElementType();
			}
			typePool.add((Type) object);
		}

		else if (object instanceof Integer) {
			if (Properties.RESTRICT_POOL) {
				int val = (Integer) object;
				if (Math.abs(val) < Properties.MAX_INT) {
					intPool.add((Integer) object);
				}
			} else {
				intPool.add((Integer) object);
			}
		} else if (object instanceof Long) {
			if (Properties.RESTRICT_POOL) {
				long val = (Long) object;
				if (Math.abs(val) < Properties.MAX_INT) {
					longPool.add((Long) object);
				}
			} else {
				longPool.add((Long) object);
			}
		} else if (object instanceof Float) {
			if (Properties.RESTRICT_POOL) {
				float val = (Float) object;
				if (Math.abs(val) < Properties.MAX_INT) {
					floatPool.add((Float) object);
				}
			} else {
				floatPool.add((Float) object);
			}
		} else if (object instanceof Double) {
			if (Properties.RESTRICT_POOL) {
				double val = (Double) object;
				if (Math.abs(val) < Properties.MAX_INT) {
					doublePool.add((Double) object);
				}
			} else {
				doublePool.add((Double) object);
			}
		} else {
			LoggingUtils.getEvoLogger().info("Constant of unknown type: "
			                                         + object.getClass());
		}
    }
}