class=org.apache.commons.math3.util.MathArrays
project_cp=/home/cfee3/software/project/BUG03/target/classes
D4J_SEED=934759
budget=120
DIR_OUTPUT=out/


java -cp evosuite-TAKE-2.jar shaded.org.evosuite.EvoSuite  \
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
