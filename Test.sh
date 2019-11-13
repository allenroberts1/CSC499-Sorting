javac CSC499Part1.java
java CSC499Part1 "Sort Me.txt" "outputAsc" "a"
diff outputAsc.txt SortedAsc.txt
java CSC499Part1 "Sort Me.txt" "outputDesc" "d"
diff outputDesc.txt SortedDesc.txt
