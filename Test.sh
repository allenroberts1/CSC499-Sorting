javac CSC499Part1.java
java CSC499Part1 "Sort Me.txt" "outputAsc" "a"
diff outputAsc.txt SortedText.txt
java CSC499Part1 "Sort Me.txt" "outputDesc" "d"
diff outputAsc.txt SortedDesc.txt
