// Group 3
package org.evosuite.seeding;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.evosuite.Properties;
import org.evosuite.utils.LoggingUtils;
import org.evosuite.utils.Randomness;
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
		stringPool.add("");

		if (Properties.TARGET_CLASS != null && !Properties.TARGET_CLASS.isEmpty()) {
			typePool.add(Type.getObjectType(Properties.TARGET_CLASS));
		} else {
			typePool.add(Type.getType(Object.class));
		}

		intPool.add(0);
		intPool.add(1);
		intPool.add(-1);

		longPool.add(0L);
		longPool.add(1L);
		longPool.add(-1L);

		floatPool.add(0.0f);
		floatPool.add(1.0f);
		floatPool.add(-1.0f);

		doublePool.add(0.0);
		doublePool.add(1.0);
		doublePool.add(-1.0);

		//BUG 14 RESPONSE 

		 // === DOUBLE edge cases: 5 most likely bug-triggering ===
		 doublePool.add(Double.NaN);                // Not a Number — often crashes or causes NaN propagation
		 doublePool.add(Double.POSITIVE_INFINITY);  // Infinity — can cause overflow or invalid matrix entries
		 doublePool.add(Double.MAX_VALUE);          // Largest representable number — may cause overflow or instability
		 doublePool.add(Double.MIN_VALUE);          // Smallest positive — triggers underflow/precision loss
		 doublePool.add(-1e300);                    // Large negative number — checks for instability or sign issues

		 
		//BUG 15 RESPONSE

		 // Ensure at least one item in each pool (minimal filler for others)
		 stringPool.add("test");	
		 intPool.add(1);
		 longPool.add(1L);
		 floatPool.add(1.0f);
	 
		 // --- 5 Bug-Triggering Doubles ---
		 doublePool.add(4503599627370496.0);       // 2^52 — previous threshold
		 doublePool.add(9007199254740992.0);       // 2^53 — new threshold
		 doublePool.add(-9007199254740992.0);      // -2^53 — test x < 0 with neg y
		 doublePool.add(9007199254740993.0);       // 2^53 + 1 — just above new threshold
		 doublePool.add(Double.NaN);               // special-case handling (should propagate NaN)

		//BUG 16 RESPONSES 

		// Add bug-triggering double values
		doublePool.add(709.78);             // Just below LOG_MAX_VALUE
		doublePool.add(709.79);             // Just above LOG_MAX_VALUE, may trigger overflow guard
		doublePool.add(1e308);              // Near Double.MAX_VALUE, extreme overflow risk
		doublePool.add(Double.MIN_VALUE);   // Smallest positive subnormal, tests underflow and denormals
		doublePool.add(Double.NaN);         // Not-a-number input, test undefined behavior


		//BUG 18 RESPONSES 
		// Add concrete bug-triggering doubles
		doublePool.add(1e-300);         // Very small positive value → triggers underflow/near-zero division
		doublePool.add(-1e-300);        // Same as above, but negative
		doublePool.add(1e308);          // Near Double.MAX_VALUE → may cause overflow when multiplied
		doublePool.add(1.00000000000001); // Precision test near 1 → loss of significance risk
		doublePool.add(1e-16);          // Tiny diff → dangerous when used as divisor (x / diff)


		//BUG 9 RESPONSES 

		// 1. Very large magnitude (test for overflow or subtraction imprecision)
		doublePool.add(Double.MAX_VALUE);  // ~1.8E308

		// 2. Very small magnitude (underflow and loss of precision when subtracting)
		doublePool.add(Double.MIN_VALUE);  // ~4.9E-324 (positive, closest to 0)

		// 3. Negative zero (can behave differently than positive 0 in subtraction)
		doublePool.add(-0.0);

		// 4. NaN (not equal to anything, can cause logic errors in comparisons)
		doublePool.add(Double.NaN);

		// 5. Positive infinity (may propagate through subtraction if unchecked)
		doublePool.add(Double.POSITIVE_INFINITY);


		//BUG 3 RESPONSES
		doublePool.add(1e308);        // Near Double.MAX_VALUE, can cause overflow
		doublePool.add(1e-308);       // Near Double.MIN_NORMAL, can cause underflow
		doublePool.add(-0.0);         // Edge case: negative zero
		doublePool.add(Double.NaN);   // Triggers fallback path
		doublePool.add(1e16);         // Large positive for cancellation test
		doublePool.add(-1e16);        // Large negative to cancel above

		//BUG 8 RESPONSES

		// --- Integers likely to trigger exceptions in sampleSize ---
		intPool.add(0);       // triggers NotStrictlyPositiveException
		intPool.add(-1);      // same as above, ensures robust negative handling
		intPool.add(1);       // smallest legal value
		intPool.add(Integer.MAX_VALUE);  // tests memory/size limits
		intPool.add(Integer.MIN_VALUE);  // pathological case for underflow logic

		// --- Doubles likely to break probability assumptions ---
		doublePool.add(-0.1);           // negative → NotPositiveException
		doublePool.add(0.0);            // combined with others, can cause sum to zero
		doublePool.add(Double.POSITIVE_INFINITY); // MathIllegalArgumentException
		doublePool.add(Double.NaN);     // invalid input → NaN propagation
		doublePool.add(1e-308);         // very small → underflow, rounding error

	 
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