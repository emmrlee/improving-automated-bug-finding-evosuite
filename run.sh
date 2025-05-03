class=org.apache.commons.math3.util.MathUtils
project_cp= #TODO: REPLACE THIS WITH THE PATH RETURNED BY RUNNING: defects4j  export -p cp.compile -w "<path to check-out buggy code>" 2>/dev/null 
D4J_SEED=42
budget=600
DIR_OUTPUT=out/


java -cp evosuite-TAKE-1.jar shaded.org.evosuite.EvoSuite  \
   -class $class \
   -projectCP $project_cp \
   -seed $D4J_SEED \
   -Dsearch_budget=$budget \
   -Dtest_dir=$DIR_OUTPUT \
   -criterion branch \
   -Dshow_progress=false \
   -Djunit_check=false \
   -Dfilter_assertions=false \
   -Dtest_comments=false \
   -mem 1500
