package day12

import java.lang.IllegalStateException
import java.sql.RowId
import java.util.*
import java.util.regex.Pattern
import java.util.stream.Collectors
import kotlin.collections.ArrayList




fun main() {
    val parsedInput = ArrayList<Row>()
     sampleInput12_.forEach { inRow ->
         val r = Row().also {
            it.line = inRow.split(" ")[0] + inRow.split(" ")[0] + inRow.split(" ")[0] + inRow.split(" ")[0] + inRow.split(" ")[0]
            it.numbers = ArrayList(inRow.split(" ")[1].split(",").map { it.toInt() })
            it.numbers.addAll(inRow.split(" ")[1].split(",").map { it.toInt() })
            it.numbers.addAll(inRow.split(" ")[1].split(",").map { it.toInt() })
            it.numbers.addAll(inRow.split(" ")[1].split(",").map { it.toInt() })
            it.numbers.addAll(inRow.split(" ")[1].split(",").map { it.toInt() })
          }
          parsedInput.add(r)
     }
//    println(parsedInput[0])
//    throw IllegalStateException()

    for ( row in parsedInput) { //.subList(1,2)
        println(row)
        generateAndCheck("", row)
    //          println(variants[0].split("."))
        println("result 1202 - temp - " + result2)
    }

    println("result 1202 - " + result2)

}


val letters_ = arrayListOf("#", ".")
var result2 = 0L
fun generateAndCheck(line : String, row: Row) {
//    val out = arrayListOf<String>()
//    for (line in inp) {
//    println(row.line.length)
        for (letter in letters_) {
            val currentLetter = row.line[line.length].toString()
            if ((currentLetter == "#" || currentLetter == ".") &&letter != currentLetter ) continue
            val newLine = line+letter
            if (newLine.length == row.line.length) {
                checkCondition(newLine, row)
            } else {
//                println(newLine)
                val amountOfElements = newLine.split(".").filter { it.isNotEmpty() }.size
//                    println("newLine - " + newLine + " | " + row.numbers.size + " | " + amountOfElements)
//                    println(row.line.substring(newLine.length, row.line.length))
//                    println(row.line.substring(newLine.length, row.line.length).split("").filter { it == "#" })
//                println(newLine.split(".").filter { it.isNotEmpty() })
                if (amountOfElements > row.numbers.size) continue

                val splitted = newLine.split("").filter { it == "#" }
                if (splitted.size > row.numbers.sum()) continue
                if (splitted.size + row.line.substring(newLine.length, row.line.length).split("").filter { it == "#" }.size > row.numbers.sum()) continue
//                println(newLine)
//                println("${splitted.filter { it == "#" }.size} + (${row.line.length} - ${newLine.length}) < ${row.numbers.sum()}")
//                println((splitted.filter { it == "#" }.size + (row.line.length - newLine.length) < row.numbers.sum()))
                if (splitted.size + (row.line.length - newLine.length) < row.numbers.sum()) continue

                if (newLine.split(".").filter { it.isNotEmpty() }.filterIndexed { index, s ->
//                        println("$index $s ${row.numbers.getOrNull(index)}")
                        ((s.length == row.numbers.getOrNull(index)))
                    }                    .mapIndexed { index, s ->
//                          println("$index - $s - ${row.numbers}")
                          Pair(index, s)
                       }.all { it.second.length == row.numbers.getOrNull(it.first) }
                ) {
                    generateAndCheck(newLine, row)
                }
            }
        }
//    }
//    if (out[0].length == row.line.length) return out
//    else return
}

fun checkCondition(generatedRow: String, row: Row) {
val toFilter = generatedRow
            if ((generatedRow.split(".").filter { it.isNotEmpty() }.size ==row.numbers.size)
         && (
//             println(toFilter)
             toFilter.split("").filter { it.isNotEmpty() }.mapIndexed {  index: Int, char: String ->
                 if (row.line[index].toString() == "?")
                                      true
                                  else char.toString() == row.line[index].toString()
              } .all {  it }
          ) && (
//              println(it)
//              println(it.split(".").filter { it.isNotEmpty() })
              generatedRow.split(".").filter { it.isNotEmpty() }.mapIndexed { index, s ->
//                  println("$index - $s - ${row.numbers[index]}")
                  Pair(index, s)
               }.all { it.second.length == row.numbers[it.first] }
           )) {
//                println(generatedRow)
                result2 = result2 +1
           }
}


//     fun allVariants(str:String): List<String> {
//     val reg: String = Pattern.compile("").splitAsStream(str.lowercase(Locale.getDefault())).map(MY_MAP::get).collect(Collectors.joining())
//     val gen = Generex(reg)
//    return gen.getAllMatchedStrings()
//}

val sampleInput12_ = arrayListOf(
"???.### 1,1,3",
".??..??...?##. 1,1,3",
"?#?#?#?#?#?#?#? 1,3,1,6",
"????.#...#... 4,1,1",
"????.######..#####. 1,6,5",
"?###???????? 3,2,1",
)

class Row_() {
    var line = ""
    var numbers = ArrayList<Int>()
    var arr = 0
    override fun toString(): String {
return "Row(line='$line', numbers=$numbers, arr=$arr)"
}
}
val realInput12_ = arrayListOf(
"##????????#?#?????? 4,1,8,2",
"?.#??????.#????#?? 1,1,1,1,1,7",
".#??.??.????###????? 1,1,2,8,3",
"??.???#???? 1,4,1",
"?????.??????##. 2,3,3",
".??#??.??# 3,2",
"?.#?##??#.?#????? 1,5,1,2,3",
"?.###??.??#?????? 4,8",
"?#?????#??? 2,1,1",
"???????..??#?. 3,1",
"??#??###.????#??.??? 1,6,2,3,3",
"???????#?????#..?? 5,2",
"....#?##????.??#?? 4,1",
"?#??.?.?#????? 2,1,4",
"?#?##????#??.#?# 5,4,1,1",
"..?.????#?????????? 1,1,1,1,1,4",
"?.????#???? 4,2",
"??.#???.????? 1,3,1,1",
".?###???????.?## 4,2,3",
"#??.?##????#????? 3,8,2",
"?#.???.?#? 2,1,2",
"?#???.#????.?? 4,2,1,2",
".???.??.#?????#?# 1,1,4,1,1",
"??..??????# 1,1,1",
".#???..#?. 1,1,2",
".?##????????###?. 2,1,2,5",
".?#???#????#? 1,1,1,3",
"#...?..?????..#. 1,1,3,1,1",
"#?#?#?.?#?????# 5,3,1",
"#.##???...?#.? 1,5,1,1",
"????????##?. 2,2,3",
"??.??.??#??# 1,1,2,1",
"???#?#.???.????.? 4,3,1,1",
"?#?????#?#??.??? 2,7,2",
"#????????.??.?##..## 1,2,1,1,3,2",
"???.?.?#??##????? 2,10",
"???.????##?.??? 1,2,3",
"#??.??.?????? 1,2,1,1",
".??????.??#?????? 1,1",
"????.?.??.?#?#?.??? 3,1,1,1,2,2",
"?#??????????#### 5,1,6",
".??.???... 2,2",
".#???#??#???#???? 1,1,1,8,1",
"#?#.???#???#?#.????# 1,1,10,1,1",
"#.?.????.#????? 1,4,1,4",
"?#???#??##???? 1,7",
"#??.??.???#?#? 3,1,6",
"#?#?.?????. 4,1,3",
"?#.#???.????? 1,3,5",
"..?.??##?#??????##?? 1,14",
"?????##?###.??. 1,6,1",
"?#?.?????##.# 2,6,1",
"?#.????..?????#. 1,1,1,1,3",
"?#????????????? 2,1,1,1,2",
"?#..????????????? 2,2,7",
"#.#??#??#?????? 1,12",
"?#??#.##??? 4,4",
"?#?.?#?#?. 1,4",
"??.?#????#??#??.#?? 1,8,2",
"..#?????????? 3,3",
"?#..#?.?#?#?????? 1,1,2,5",
"??.??..?????? 1,1,2",
"???#???#.????# 6,3,1",
"????#?.??#??.? 1,1,4,1",
"?#?#??.????..??? 1,1,3,2",
"???#??#???.??#???#? 1,8,1,1,3",
"?.??????..#??? 1,5,1",
"??????.?#??? 2,1,3",
".?#??????.?#####? 3,1,6",
"#?##??.##??????? 5,8",
"??.#?.??#?####? 2,7",
"????#???#?##.????? 4,4,1",
"????#?#??????#??? 1,3,1,1,4",
"??..???.???##??#.??# 1,3,4,2,1",
"#???????..????#??? 3,1,2,7",
"?????.#?????? 1,7",
"#??#?#????#???.?? 1,6,2,1,1",
"????##?????##?????. 2,3,2,4",
"?..#??#??##. 2,1,2",
"?.#??.##??#????#?? 1,11",
"?????#????.?????##?? 10,5",
"?##?.?????.??? 3,3,1",
"???.??#??#?#? 1,7",
"?.??.?????? 1,1,3",
"??#??.??????.?. 3,1,2,1,1",
"??????.?##??????#? 2,3,9",
"..??..##.??? 2,2,3",
"#?#?#?##..?.#?#?#?.? 3,4,5,1",
"?#????#????.# 7,1,1",
"?????.?#.?#????#??? 1,2,7,1",
"??..?.??????????. 3,1",
"??.?#?.?.#??#? 2,1,5",
"?.???#?????#???#.??? 1,7,2,1,1,1",
"????.?????#???#?# 1,1,12",
"??#?????##??#????. 1,9",
"..?#.??#?#?????#?. 1,9",
".???????#??? 2,4",
"???..?????? 3,1,2",
".#?????#????#? 1,5,2",
".?#??#???? 1,3",
"????.??##??.???? 1,1,3,1,1",
"?.?..???????. 1,1",
"???.?.?.?? 1,1,1",
"???????..???#??. 5,1,4",
"???????##??. 1,2,3,1",
"?.??.?.?????##???? 1,8",
"???#?.?#???#??? 4,3,2",
"#.##????## 1,3,2",
"??##????#?#??????# 9,5,1",
"??#???.#???#?#??? 1,1,1,9",
"??#?????#??#? 5,5",
"??????#...????#?.? 6,5",
"??????##??#? 1,1,7",
".?????.???? 1,1,3",
"???##?#####?????# 11,2",
"?.?.?#?#????. 1,5,1",
"..???????? 2,2",
"?????.?#?.####? 2,2,2,5",
".??#.?#?#... 3,4",
"???#??#?.???????? 7,4,1",
".??????????????#??? 1,7,5,1",
".??##??..?###?#??? 3,8",
"??#??????.?##? 6,3",
"?###?#?????.????#?#? 10,4",
"????#.????????????? 1,1,2,3,3",
".#.???##??#??? 1,6,1,1",
"??##..??#?#??# 4,1,1,4",
".??#?????? 3,1,1",
"#???.#?.??#??????#?# 3,2,5,4",
"???.??##??? 1,6",
".?.???.??#???...???? 2,1",
"???#?#?????????.#? 1,2,2,1,1,1",
"?#??????..#?. 3,1,1",
"?.???.?#?#. 1,3",
"???#?????.#?# 6,1,1,1",
"???.#??????#??#?.. 2,3,6",
"?????##?#??#????. 1,9,1",
"??????#.#???#?#?. 6,2,4",
"????#???#????# 11,1",
"#??.??..##.???????#? 3,1,2,1,6",
".#???#??#?#??????.?? 15,1",
"?????#????#?????##?? 1,1,11",
"?#.??#?#?? 2,2,2",
".??#??#???###?????? 1,12,1,1",
".???.?.??? 3,2",
"?????#.#.??.#.???? 2,3,1,1,1,3",
"???#??..#????.????.# 1,2,1,5,3,1",
".?##????#???#??#?? 9,4",
"???.?#???????## 1,4,1,2",
"?..????????.? 2,1",
"?#???#?#??? 1,5",
".????????#?. 6,2",
"??????????. 4,1",
"?#????#???#?.. 1,1,1,3",
"##.#????.# 2,4,1",
"#?#?#??.?#?# 3,3,3",
"?????..?.??#?#?.??. 2,1,5,1",
"?#???##????????. 1,5,3",
"##????.?.###.? 2,1,3",
"??##???.?#??##. 7,5",
"???#.????.?#?#? 4,1,3",
"??#???#?##??# 2,1,4,1",
"??.#????#?#?? 2,1,5",
".????.???#?.# 4,1,1,1",
"???????#???# 1,1,1,1",
"??.?.?##?????? 1,3,1",
"?.?#??#?##??? 1,4,3",
"??.#?..#?????? 2,2,4",
"..?.????#????? 3,2,1",
"???.?#?????? 1,1,1,3",
".##?#???#?????.? 5,1,2",
"?.??.??.??? 1,1,2",
"?#???#???##??.??#? 12,1",
"????.#??.???#?? 2,1,1,1,3",
".???##????#.#?.??#? 1,5,1,1,1,2",
".?.?#????????##? 6,5",
".??????##??.??#??.? 5,3,1,2",
"#??.???##? 1,1,3",
"#???????#????.?#??? 1,1,1,7,1,1",
".#?#??.#?? 3,2",
"?????#??.??????.#. 1,3,3,1",
"???????#??.?.? 1,4",
"?#.???#?.?? 1,3,1",
"???????#????.?#??# 9,4",
"??????????####.#?? 3,8,3",
"???..?#???#???????? 3,14",
"..#?#??#??#?? 7,2",
"?????.?#??.? 1,1,1,1",
"??#???#?.? 3,1",
"???.???#?? 1,4,1",
"#?????.?.?#?.??..? 6,2,2",
"##??????#?? 6,3",
"##?.#....?.? 3,1,1",
".?.?#?#???#? 1,8",
"##???#.?..#?#? 6,1,3",
"#.???##?.?.?# 1,5,2",
"?????.??#??##??.?.. 4,7",
".?#??#???#?#???# 3,2,6,1",
"??????.#?????#?#? 1,2,1,1,3",
"??.????.?? 1,1,1",
"???#??.#?##.?? 3,1,2,1",
"????#????? 3,2",
"??#???.#????#??? 1,1,1,1,6",
"?#????????.??? 2,5,1,1",
"?????????.?##? 4,3",
".??.#??##. 1,2",
".#???#?#?#?.???.??? 9,1",
".?#?#???#.? 1,5,1",
"?###?.??#?.??? 4,1,2,2",
"??.??.??.### 1,1,1,3",
".?##??????.??#??.??? 3,3,1,3,1,1",
"?#?.??.?????#??#??. 1,1,1,5,2",
"???##??.#???#?.?. 3,1,1,2,1",
"#???#?.?#?...??????# 1,3,3,1,5",
"??#??????#??. 3,7",
"?.??????????? 6,1",
"?..????#???? 5,1",
".?#?.???#?#?????#.?? 1,7,4,2",
"????#?#???#?? 5,2",
"???#??????#?????. 11,1",
"???..???#???#? 1,1,1,7",
"?.??#?????.?????.? 1,4,2,1,2,1",
"??????????#? 3,2,1",
"?###.??###?? 3,4",
"??#??????.?.?##?#??? 3,4,7",
".#.######?.? 1,7",
"?????###?#.?#?????.. 7,6",
"???.?.#??.??..? 2,2,2,1",
"????#.??.?.??? 1,1,1,2",
"?#???.??????# 2,1,2,1",
"?????..??#??# 4,3,1",
"?.#..?#..??#?.?# 1,1,2,4,2",
"??????.?###.?? 1,1,4,1",
"?#?##?#???#????? 10,1",
"?.?##??.???#??#.?.? 1,2,7,1",
"..??#?#??#??????.??? 5,6,1",
"#???#?#??.#???.? 2,5,2",
"???#??????###?? 5,4",
"?????????.?#?#? 3,3",
".???????????##?#?. 8,5",
"?.?????#.? 1,2,1",
"?#.??????#????#?? 1,1,1,1,5",
"????###?###.? 1,7",
"?????#?#??...#?? 8,1",
"###?...?##? 4,2",
"????.????. 2,1,1",
"??.##?#?#.??##??. 6,1,2,1",
"???????#????# 1,2,3",
"??#????##???????? 5,3,1,1",
"???#.??#??? 2,1,5",
"????#??????#.???? 5,1,1,1,2",
"????.????..# 2,1,1,1",
".??????##??.. 1,6",
"??#??.???..#?#?##?? 2,3,1,5",
"????.#?.??.?#?.?#? 3,2,2,3,2",
".???????????#??#. 1,5,1,2",
".?#????.??????#???? 4,1,1,1,2,1",
"#???##??????? 2,4,1",
"##??#???#??#?#? 3,1,8",
".???.?.#??.? 1,1,1,1",
"?#??##????.?#??#??## 3,2,2,2,1,3",
"?????????#??#???#??? 1,5,4,1,3",
".???.??????. 2,1",
"???#?????????? 2,2",
".?#.???#??.#. 1,1,3,1",
"????.???#??#??.#? 2,1,2,2,1",
"???#.?????????? 1,2,2,1,3",
"??#??????.??.##??? 1,1,1,2,3,1",
"??#?????????.??..??# 11,1,3",
"#?##??????#?????? 6,1,7",
".?#??#.?##? 5,2",
"???.?#..????..?? 2,1,1,2,1",
"??#?#???.????? 6,5",
"???.???#??#?.. 1,1,1,5",
"..???#???.? 3,2",
"#???###??.???? 9,2",
"???.????.?# 1,1,2",
"????#???????#?? 1,5,3,2",
"???#??????#?? 1,2,6",
"?##????#.#?.? 7,2",
"?#.?#??#???? 2,1,2",
"??#.??#??? 1,2",
"?.#.##.#??##?????? 1,1,2,6,1,1",
"??#????????#.??? 3,3,1,1,1",
".#???#??##????..#?? 11,1,1",
"#?????##?#?#????#?? 4,12",
"???????.??#?.?#? 4,1,2,1",
"?##??#??#??#??. 3,8",
"..?.?.??????????#?? 1,2,1,7",
"???...?#?.?#.# 1,2,2,1",
"???????..? 2,2,1",
"?#???#???#???## 2,4,1,1,2",
".##.??#????. 2,2,3",
"??.#.??#?.?#?? 1,4,2",
"??#??.?#???.? 3,1,2,1",
"?.??.???#?????? 1,10",
"???#??????????. 1,3",
"??#???????#??... 4,3",
"??????#???.???.?? 8,1,1",
"??.???#???##?.. 1,1,1,4",
"?#????#?#????#? 8,3",
"?????????#??.? 3,4",
"??.#????#?????.?# 1,6,1,1,2",
"????##?#..????..### 1,1,2,1,3,3",
"?..?#??#?#?.???#???? 5,2,7",
"?.#?.#????#??? 1,1,3,1",
".???#?.?.. 2,1,1",
"????#.?.?# 2,1,1",
"##?.#???#???.#?.???? 2,7,1,1,1",
"#?#?..?????##.?#??? 4,7,5",
"??.??.???#?? 1,1,2,2",
"????#.????#???##?? 4,8",
"#???????#?##?. 2,2,5",
"?.???###?#??.. 1,3,3",
"?####????? 4,1",
"??.#.??#????????# 1,1,9,1",
"?.??.????? 2,5",
"#?????#???#??? 1,9,1",
"?#??????????#?.#?? 3,10,2",
"??????.?.#?? 1,1,3",
"???#??###???#?.? 8,2",
"??#####?#????.? 8,2",
"?#??????#.? 6,1,1",
"?#?#???.#??#???? 4,2,1,1,1",
"????#????##??.?# 1,2,1,3,1",
"??.?#?#.???.??#? 4,1,4",
"?.??.???????#????. 1,1,1,5,1,1",
".?#????##??#??#??##? 3,9,4",
"??.??.?????????. 2,2,4,1",
"#?.???#???.??????#?? 1,1,1,1,7",
"?##?????????#??????? 3,9,3",
".??...?#?#???? 2,4",
"??.?#???????? 1,2,3",
"#..??????#???#?#.? 1,1,1,3,3,1",
"?.#??##?????? 1,3,2",
".????..???????? 4,2,3,1",
"?????????.?#????.?. 6,5",
".???.???#?#??????? 1,1,1,4,1,1",
"??##?#?????? 3,1,1,1",
".#?????????. 1,1,2",
"?#?????????#?????.?# 8,6,1",
"?.#?#???.??.? 3,2,1",
"###?..?#???? 4,4",
"??#???????? 4,2",
"?????#??#..?.. 1,5,1",
"??#?#.?.#?#??? 5,3,1",
"???..?????.???#????. 1,3,2",
"????.?#????#?.??? 1,1,8,1,1",
".?#.??????????#.?? 2,1,2,1,1,1",
"?###??..???# 5,3",
".?#???..?. 1,1,1",
"#?????.?#?????? 1,1,4,1",
"#.##??#??#?#??.?? 1,5,4,1,1",
".?##?...???..???#?#? 3,3,6",
"??#..????? 2,2",
"?????.????. 1,1,2",
"#?????.????##??#? 2,1,9",
"?????????##?..????? 9,2,1",
"???#..??#??? 2,3",
"#????#####?.?????? 10,1,1,1",
"?????.???#?????? 1,1,1,5,1",
"??#???.????.??# 5,1,1,1",
"?.??????.?##?? 1,3,3",
"?#.??.#????????.#? 1,2,2,4,1",
"??#?.???..# 2,1",
"??.??#??##. 1,5",
"?##???##?? 4,3",
"#???.?#???..???##.#? 1,1,2,1,5,1",
".???####?#. 7,1",
"??????###??? 1,1,6",
"????#?.?.???.?????.? 3,2,5",
".#?.?????#?#??.??? 2,1,2,3,1,1",
".#?.??.?##.#? 1,1,2,2",
"???.#??????????.# 1,1,1,4,1",
"??#?#???#?# 6,1,1",
".??#????.#.?. 3,3,1,1",
"???#???.???. 3,3",
"?#?#.?#?#?#?###??.?? 4,11,1",
"?.?.#????. 1,1,2",
"..?##?.?#. 3,1",
"???#?.#?##??..#.??# 3,6,1,1,1",
"?#???.????.? 4,3,1",
"??.??#?##???#? 1,7,1",
"##??#.???? 5,2",
"???##??#??#??#???... 1,13",
"?#????.?#?.#??? 2,2,3,1,1",
"?.??.##??? 1,4",
"????.?#???# 2,1,2",
"??#????.?# 2,1,2",
".????????#????#?? 4,2,2,2",
"???#?????.?#??.??. 1,5,1,2,1,1",
"????#?.#.? 1,1,1",
"????????#?#?###?. 1,9",
"???.?????????????? 1,9,4",
".????#.???#..???? 3,2,1,1,1",
"??#??##??????#????? 1,8,2,1",
"???#.????.?#?.????? 1,1,4,1,1,1",
"???.?????#?? 1,1,1,5",
"????.???.?? 2,3,1",
"??????##.?#???.??? 8,1,1",
"???#.?.#????#?. 1,2,7",
"????#??#???.#?#. 8,1,1",
"???????????##?.?.??? 2,2,5,1",
"?..???.?###.#???. 1,2,4,4",
"#.??.?????#??#?????? 1,8,3",
"..#?#?????##???#.? 1,9,1,1",
"?.#?##?????????##? 1,5,1,1,4",
"???.???#????##??? 2,1,1,6,1",
"?.#???.#.????? 3,1,3",
".#?#???.?? 1,2,1",
"????.?#??#?.? 1,1,2,2",
".???????.???#?? 3,4",
"#?.??.#??##?#??????? 1,1,2,10",
"?###???#??? 3,3,1",
"?????#?????#?#???. 7,1,1,1,1",
"?.?????#??????#?#. 4,3,1,1,1",
"..?#.?.#.#??#???.?# 2,1,1,6,1",
".?..??##.? 1,3",
"??#???#??#??#??#???? 3,2,12",
".?#????????#. 7,2",
"?#?.????.?. 2,3,1",
"#??#?#????#.#????#? 1,1,3,1,1,5",
".?.????????.? 2,2",
"#.?#???????.#??#?. 1,5,1,1,3",
"#???#??.?.#? 1,3,1,1",
"?.?.??###??? 1,1,5",
"?..????#??#?#??????? 1,10,4",
"??.#.???#.? 1,4",
"?..????????? 2,1",
"#??..###?.? 2,3,1",
"#.?#?..?#???.?# 1,2,5,1",
"#.??????#?.????? 1,1,4,2",
".?????##???#??.? 1,8",
"??????????? 1,2",
"???.???#?????.???? 3,1,1,1,1,4",
"????????.. 1,2",
"#?????#.?.#.??#.?# 7,1,1,1,1",
"?..???????#???? 1,2,1,5",
"??..???#.. 1,4",
"??.#.?????? 1,3",
".???#???#.???? 5,1,2,1",
"????.???.?? 4,2,1",
"#.???????#?#???. 1,13",
"?#???????##?. 3,5",
".???????.?#???# 1,4,1,1",
"??#???.#???#? 2,5",
"???.??#???? 1,4",
"???????????.? 2,1",
"?.???###??. 1,1,5",
"#???.?#?.??? 1,1,1,1",
"#.??.??#?????? 1,4,1,1",
"???????.?.. 1,2,1",
"#????#?.#.??? 6,1,1,1",
"?????#.?.?#??.#?..?? 3,1,1,3,2,1",
".???..????#??? 1,1,3",
"?????.????.?#? 1,1,2,2",
".?#.??..?#??##? 2,1,5",
"????.??#?#. 1,5",
".???.?..##??? 1,2",
"?????#????##????? 1,1,1,7",
".??#?#?#???.#?.? 1,6,1,1",
"#.#????????#?#?.???? 1,1,6,1,1,1",
"#?.?.?##?#??#?? 1,1,2,1,2",
"???#??.?#???# 1,2,3,1",
"????.????#?#??## 1,1,1,1,5",
"..????#?#?.? 3,3,1",
".??###?#..?##.?? 6,3",
"???.?#?????. 2,1,3",
"???#??????#????#? 6,1,2,2",
"??.?#??.?#.?.? 1,3,1,1",
"??????????..????## 1,1,3,1,3",
"?.??.#????.???#??.#? 1,2,1,1,4,1",
"?#????##??# 1,2,5",
"???#.???#.????#???? 1,1,3,5,1",
"#.???????.???????#. 1,1,1,1,4,1",
"#?#??.#????????#. 5,2,4,2",
"?????#..?#???#???? 6,5,1",
"?.?#??.??#? 4,3",
"?#???##??.???.?#??.? 8,4",
"??#??????#?#?#. 4,1,6",
".??#????#????#?. 7,3",
"#??#???##??.??#??. 9,1,1,1,1",
".??##??.##??.? 5,4,1",
"??#??##??#??????# 3,2,2,6",
"#????#???????????? 1,1,1,4,2",
"##.??????????#?#?..# 2,2,8,1",
".??#???#??.?## 4,1,2",
"#????#?#??#.#???..# 1,1,7,1,2,1",
"???????????## 2,1,2,3",
"??#???.#??.. 3,1,1",
"???????#.???#????. 2,3,1,4,1",
"???.?#?.#?#?#?? 2,2,1,1,1",
"?#???.???#?#? 2,2,1,2",
".##??#?.????##????#? 5,11",
"###??#??.#????# 3,1,1,3",
"??##???####????.??? 4,5,1,1,1,1",
".?#??.??#???##????. 3,1,5",
"???##????.????. 1,3,1,1,2",
"??#????????#? 3,2,5",
"?#??..?###?.???.. 2,4,1",
"##?.??.????#?? 3,1,1,4",
"#????#?#????#?#????? 3,13,1",
"?.??????#? 1,1,1",
"#?##??#??????..?? 9,1,1",
".?.??????#?#??# 1,1,7,1",
"?#??.#????# 2,1,2",
"????#???##??#? 1,7",
"...###?.??#.?? 3,2",
".??#?????.? 3,1",
"???#??.??. 4,2",
"???.?????#???? 2,1,2,4",
"#??#??.??##??? 1,2,4",
"?.###?.??#? 4,1,2",
"?#?.??..#??##?#??.? 2,1,8",
".??#.?????..#??#? 3,4",
"??????##??..##?.?. 2,5,2,1",
"??????.??? 4,1,1",
"?#???.??#?????#? 2,1,3,5",
"??#?#########.?? 12,1",
"????#?.????? 1,3,1,1",
"?.?#??#??? 3,1",
"?#????#?#?.?.#?? 3,6,1,1",
"#?.??????#??#??.?.? 1,10,1",
"???.??????. 2,2",
".????????. 1,2,1",
"??#..#??.?? 3,2,1",
"#?#?#??????#???????# 16,1",
"?#?.?##.?#??# 3,3,2,1",
"??.?????.???? 1,1,2,1",
"..??#.?.?#?#?##? 3,8",
"??????.??#?.???? 2,2,4,1",
".??#??#.?? 3,1",
"..?.?.??##??????.??? 1,1,6,1,1",
"?#???????????? 8,1,1",
".##???.?#????.??? 4,3,1,1",
"?#?#?.??.###????#??? 4,3,2,4",
"..?.?????#??###???? 1,12",
"#??#??.#?#?? 5,1,1,1",
"?#?#?.#???#. 1,1,1,3",
".#??????.??...??# 6,1,1,1",
".????##??##?????#?## 11,5",
"?#??#..????? 5,2",
"?????.?##?????#? 1,1,3,2,2",
"?..#.?#??##??? 1,1,1,6",
"????#??#????.?# 1,3,2,1,1",
"?????????? 1,2",
"?????.#?.? 1,2",
"?####?#??.??#????##? 8,8",
"?.?#????????#???. 2,1,7",
"?#?#??????? 6,1",
"?##?##????.???#???? 9,2,1,3",
"?.#????.???..???? 5,1,2",
"#.??..???????#??? 1,2,1,6",
"??????????.?.#????. 2,3",
".???.??????###?. 3,6",
"#.#??.?.???????#??. 1,1,1,1,3,5",
"????#.?..###?#.???? 1,3,1,5,1,1",
"???#???#??.? 1,3,1,1",
"??.?.?.?????# 2,1,1,1",
"#.???????.????? 1,2,1,2",
"#?????.?#???#? 1,3,2,2",
".#???????###???? 3,3,6",
".??#????????. 2,4",
".?.#?.??.????#?#??? 1,2,1,9",
"?????..???????#..?#? 2,8,2",
"..#??#??##??#??? 2,9,1",
"?.??????#.#...?.# 1,5,1,1,1",
".?????#???#?..?? 4,3,1",
"???#?????? 1,1,1",
".????????#?..? 10,1",
"..??#??#????????.? 8,2",
"?.####?#???#??????.# 1,12,1,1",
"?.?#??#?????.#?? 2,5,3",
".????????????? 9,1",
"?.?.##?#?????###. 1,5,3",
"?#?#?#??????? 3,4,1,1",
"??##?.???????? 3,2,3",
"????#.??###????# 4,3,1,2",
"????##???##? 1,7",
"?????#???#.??#?? 8,2",
"#??#?#?#.#??#???.# 2,3,1,2,3,1",
"??.????#???.??.?? 1,7,2,1",
".?##?#?..????..?? 5,1",
"???#??#???????. 10,1",
"??#???#????? 1,3,1,3",
"??????????#?. 7,1",
".???.?..????????##? 2,11",
".????????????????##? 10,1,6",
"?##???????#?? 4,1,2",
"#?.??#??##??#?#? 1,5,1,1",
"?#?..???#??#????.# 2,7,1",
"?.??#.?.?#??. 3,3",
"?#?#???????????? 9,1",
"????????#?? 2,1,1",
".#?.?###?#??.?.?#. 2,7,2",
".?.????.##. 4,2",
"?????????#??#? 2,6",
".?..??#?????.?##???? 1,4,2,6",
"#?.????..? 2,1,1",
"??##??.?????????.? 5,4,1,1",
"?????#??#??.??#????# 3,5,8",
"????.#???.???????#?. 1,1,4,3,2,2",
"??#.??#??.? 3,3,1",
"???#???#???#? 4,1,4",
"#???#?#??##??#?##??? 2,5,5,2,1",
"??...?#???? 2,2",
"???#.???##.. 4,2",
".?#?###.????? 2,3,1",
"????.##?.?.?? 1,2,1,1",
".##???????????. 5,4",
"?#??##??.??#??# 7,1,4",
"#??#?..??.??? 5,1,1",
"#?????.??.?..??#.# 6,1,1,1,1,1",
"#??#.?###???????#??? 1,2,5,1,2",
"????.#?????????#? 3,5,2,2",
"????????#?#?. 2,3",
"??#.#?.???? 1,1,2",
"??????.?#??#???? 4,8",
"??????#???? 1,5",
".#???.?.??. 1,1,2",
"#..??#??????#.??..? 1,1,1,5,1,1",
"?????????.??.. 2,2",
".?#?..#?#?#??????##? 3,1,4,7",
"?.???.???.#????# 1,1,1,4,1",
"???#???.?#.?? 3,1,2",
"?#??.?#???.??#?#?.# 1,1,2,2,3,1",
"?#?#???#?#?#?# 1,1,9",
".?#?????#??#?.?? 1,4,1,2",
"????###????#???. 1,10,1",
"??.??.???????#. 1,2,1,3,1",
"??????#???##? 1,7",
"?.?#??.??#????### 1,1,10",
"???#?#..??? 6,3",
"#?????.????? 1,1,1,1",
".???.??##? 2,3",
"?????##?.?.?? 3,3,1,1",
"?.?.??#?????#? 1,3,1,1",
"??.?.?#??##. 2,6",
"???.?#.???##?#?.?##? 2,7,3",
"?.???#??#?#?.#??##. 8,1,3",
"??..?#??..? 1,3,1",
"??????#???#????? 1,1,4,2,2",
"??#.????#.?? 1,2,1,2",
"#??????##???????.#? 9,1,1,1",
"#?###????? 5,1",
"???#.???#.??.#.???? 4,3,1,2",
".#????????..?.?#??#. 9,1,3,1",
"?.???????.???#? 6,1,1",
"?.??#?#????? 6,2",
"?????????.? 1,1,4",
"??????#???# 1,8",
"#????.???###??? 1,1,1,5,1",
".?.?#???##?#? 1,1,7",
"#?#??.###??#?.# 1,2,7,1",
"?#?.#???#?. 2,1,4",
"?#.??#?????#?###? 1,1,1,1,6",
".??????##?#??###. 11,3",
"..????#???#?????? 1,3,7",
"?##??????.????.? 9,2,1",
"?????.?.?#? 2,1,2",
"???????##????#?? 4,2,2,1",
"?.?#???????..???.??? 1,8,2,1",
"?.??????##?.?##??? 6,4",
"?#.??.??#?###?? 1,1,7,1",
"..#?????.??# 2,2,2",
".???##???.? 4,1",
"?#??????.??. 3,1",
"?.?..??.???#??????? 1,1,2,5,2,1",
"??.??????#?##?.# 1,1,1,7,1",
"??#??.##?. 3,2",
"?..??#????.?????. 2,1",
"?#.#???#???.??? 2,2,2,1",
"..?#?..???.?? 2,2,1",
"???#?#?.?.? 1,4,1",
"#?#?#????#?????? 10,1,1",
"???????????#??#???# 5,1,2,1,2",
".?.?.#?#??#??. 1,8",
"???#??##?#??.??#. 10,3",
"?#????.???..?##?? 5,1,1,2,1",
"??..??###?#.? 1,6",
"?#??#????????.??#?. 8,1,3",
"???.???#.???#?# 1,4,2,1,1",
"????#??.??.??????? 7,1,6",
".?..?.?#?#??#?.??? 1,1,1,1,3,1",
"??##??#??#????#. 8,3",
"?..?????..????. 1,3",
"#??.????????#??? 1,1,9",
"?.#.??#??..???#???# 1,5,8",
"?.?#..?..#????.?# 2,1,4,1",
"??.#.???#?## 1,1,7",
".??...?.?? 1,1",
"?#???#??.??#?#????? 4,1,1,7,1",
"???#.??#?????.#? 4,3,1,1,2",
"?#??#?#???.?#??.?. 10,3",
".#??.#?#.???. 2,1,1,1",
"??#??.??#???#?? 3,7",
"????.???#?.??#?### 1,1,1,2,7",
"#?.???????????#? 2,4,1,2",
"#?#?..?#???.# 3,1,1,1",
"??.?#??.???.##??? 3,2,4",
"?.?.??#???##? 1,1,2,4",
".?##???.?. 4,1,1",
"?????#??##??#?? 1,9",
"???##?.????#?? 3,7",
"???#??#?????##.?##?? 2,9,3",
".????..??. 1,1,1",
".??.#.?#??#??..?#?? 2,1,7,2",
"#????##.?.????.?.? 7,3",
"#??.?#?#.??? 1,1,1,3",
".??.?##???. 1,4",
"?.#??#?##??????#?? 7,8",
"?.???#.?.?.?#?#??? 1,1,1,1,1,4",
"?????.?#?#??#? 1,7",
"???.?.#??#?? 1,4",
"?.##??.??. 3,1",
"????.?????.#?#?? 3,3,1,2",
"?.?.??##??#? 1,4,3",
"..???.??.. 1,1",
"#??#?????.#????????? 6,2,2,3",
"????.??????. 2,1,1",
".???.???#?? 1,1,6",
"?.??#?##?. 1,6",
"??#?##??.? 1,4,1",
"?.????##?????? 2,8",
"??#??#?.????.# 6,1,1,1",
"?#?###?????.???.? 6,1,1,1,1",
"?.###???#??#?#.???#. 12,1,1",
"???#??#???? 1,5,1",
"??#???.??? 3,2",
"??.#????????##?????? 2,1,5,5",
".????????#?..?.?.? 1,4,1,1,1,1",
"??#???###?#?? 1,5",
"#..??.??#??##??? 1,1,8",
"?????##.????? 3,2,1",
".??.??#?#?.??#?????# 2,6,9",
"###?.?????.? 3,1,1",
".????.?##.#??#??.? 1,1,3,1,4,1",
"?.?.????.?#.?.?# 1,1,1,2,2",
"??##???.??.#? 3,1,1,1",
"?????#??.?????#????? 1,6,1,4,1",
"??#?#?????#?. 1,1,1,6",
"????????.??.#..# 2,1,2,1,1",
".?#?..??.???????.?#? 2,2,7,1",
"???..??.?..?#.??? 1,1,1,2,1",
"#?????????#??#?#.? 1,1,6,1,1,1",
"??????#???????? 2,1,1,3,1",
"????#??#???#???#? 1,6,1,1",
"????.?##???# 3,3,1,1",
".??.????.?.?#?? 2,3,1,1",
"?#????###?.???#??#.. 2,4,2,1,1",
".??#????#? 2,2",
"#??????.???#?#. 2,1,1,1,4",
".?.???#.?##????## 1,1,1,3,4",
"???????#????#?????? 1,14",
"???##??##?###???#?? 2,11,1,1",
"#.#???##???.#?.???? 1,3,3,1,2,1",
"??#?.??##??? 2,2",
".?##???#.#??????. 2,2,7",
"#??????.??? 7,1",
"??#.??#?##.#?#???# 1,1,2,2,3,2",
"?#??????#?#??.#??? 3,6,1,1",
"????.?#?##????#.?#? 1,6,2,1",
"?.????##???#. 1,4,3",
"??#????????.??? 5,1,2",
".##???.?###?###?#??? 5,10",
"????#???????#.? 1,5,1,1,1",
"?????#??##?#. 2,7",
"??##???.??.??????. 5,2,2,1",
"#??????#?.??.?? 1,6,1,1",
"??#??????#?#??????.? 3,12",
".???.#???#?#?#.# 1,1,7,1,1",
"?..#?##?##????. 1,4,6",
"??#??.?????..?. 1,3,1,1,1",
"?#??#???.?##?. 2,1,1,3",
"??#??#??##?..???# 9,1,1",
"?#??.??#?????#?#?#?. 3,3,5,1",
"?#.#??????####??# 1,1,2,8",
"#???#?##??????.? 11,1",
"??.??.?.#????#?.???? 1,1,1,1,5,1",
"???????#???? 1,4,1",
"#??##????????###??. 1,5,3,4,1",
"#..?#?.??#?.?? 1,2,2,1",
"???.#?#????? 1,7",
".??#?????? 1,3",
".??#??##????##. 9,3",
"#.??????##?#???? 1,1,6,1",
"##??.##??.?. 2,2,1,1",
"..??#???##??.? 3,5,1",
"?#..?.???..# 2,1,2,1",
"?#.???##?#?.. 1,1,5",
"??#.?#??..????? 3,4,1",
"##??##??#????# 2,5,1,2",
"?#?.#???.??. 2,1,1,2",
"?##????#????.##? 3,6,2",
"??#??????????.? 6,2,1",
"?##?.????? 4,1,2",
"?.??##??#?#?? 1,3,5",
"#??.#??..#?#?##? 1,1,1,1,7",
"????????.??????#??# 1,1,1,1,8,1",
"???#.#?.#?##??##?# 2,1,4,3,1",
"???????????#??. 3,6",
"?????????? 3,2,1",
"???##?.?????#?.?? 2,3,7,1",
"???###??##???#?.#??# 11,2,1,1",
"?????##?#.??. 9,2",
"???????????????.?? 13,1",
"##?????.#.?#??????? 4,1,1,7,1",
".?#??.?#?#??#???? 2,7,1",
".?????.???#?#?? 5,1,1,3",
"???#?.#.??.??.??.? 1,2,1,1,2,1",
".???#.??#?... 1,2",
"?#???#????. 1,4,2",
"?#??..??#?? 2,3",
"?.#???????????.?? 6,3,1",
".????????##?..#?# 2,6,1,1",
"???##??.#.?.?##?? 1,2,1,1,4",
"??????#??##?.??????. 2,3,4,3,1",
"??#??#?..?.? 5,1",
"????????????#..????? 1,10,2",
"..#??#????????##? 2,2,2,6",
"?.#?###??? 1,3,1",
"???##??.??.?#??#? 4,5",
"?#???#????#??.??.?# 2,4,5,1,1",
".???#..#????????#??? 3,4,3,1",
"?????.??????? 1,5",
"..???????. 1,1,1",
"..?#??.?#. 2,1,1",
"?#.#????#?.#.? 2,3,1,1",
"??????##?????.#.? 1,8,1,1",
"??#???#??.#??? 7,2",
"????#???.??.???#?#? 6,1,1,4",
"?????#??###?#????.? 1,8,4",
".??????.???? 5,1,1",
"??.???#???#??.?##?? 1,7,3",
"??#?#??#?#.??.??. 6,1,1,1,1",
"#????..#??#??#? 3,1,1,3,1",
"???#???#??##???? 10,3",
"???.???.#??# 2,1,1,1",
"##????#?#??#??##?#? 5,12",
"??#.?.?#..?.??? 1,1,1,1,2",
"?#???.????.?????? 2,1,4,1,1",
"?#?.??###?? 1,4",
"??#?#???#??. 4,1",
"?#?.??##???????#.?. 1,12,1",
"??#???.??.#? 3,1,2",
"??##???..?#???? 4,4",
"?#???#??..?#??.? 7,4,1",
"?????????#?#?##??#?. 1,17",
".?.???.??##??.... 2,4",
"??.?.?#?#????#..???# 1,8,1,2",
"?#??#????#????#.??? 8,1,1,1,3",
"??##?????#?????.? 11,1,1",
"?#?????#??##??????.? 3,9,1,1",
"????#???.?? 1,5",
"??????#?????. 9,1",
"..??#.????#???##.??. 1,1,2,6,1",
".?#?#..?.?????? 4,1,1,3",
"#????#.??.?#?.???. 1,1,1,1,1,3",
"??????????. 1,4",
"?????#????? 5,1",
"#????..????#??# 3,1,1,4",
"?????.#?.#??? 4,1,3",
"??.?##.???.?? 1,3,1,1",
".##???#??#?????... 11,2",
"???????##?#.. 1,8",
"?.#..?#????#??????? 1,1,4,1,5",
"#?????#???????#??? 1,1,3,6",
".?????#??###????.??. 12,2",
"?.??##?????.???????. 1,1,7,1,1,1",
"????????.?. 4,1",
"#???????.??..?? 1,5,1,1",
"??.###??????? 1,3,1,2",
"#.???#.???#????#? 1,1,1,9",
"????#.???# 1,2,3",
"???..#??.???.?#???? 2,3,1,1,5",
"?????.?#???????? 5,2,1",
"?.??#..?????.?????? 2,1",
"?#####?.???????#? 6,1,6",
"????..???#.?? 1,4,1",
"..???#?.?? 1,2,1",
".?#??????#?.?.? 3,2",
"????###..??# 3,1",
"???????????.?. 1,4,2",
"?#?.?????.????? 1,4,1,1",
"??????#?##?#?#??? 1,10",
"?????#?????#?? 8,3",
"?????##?#?##???????? 5,8",
"??#??????? 3,1",
"#?.???#???????.## 2,3,1,1,2",
"???.????????? 2,5",
"????#??#??.?. 2,1,3",
"????.?..#??. 2,2",
"???#?#.?#?#??#????#? 1,1,1,12",
"??#??#?????# 7,3",
".????.???. 2,1,1",
"???.??.??. 1,1,1",
"?#?.#.????? 2,1,2",
"???#???##.. 1,6",
"?##?#??#.#????.???? 6,1,1,2,2,1",
"?????????? 7,1",
"??#?.???#?##???? 3,1,9",
"??#???????.? 2,1,2",
"????.???#?.??#?? 1,1,3,1,3",
"????#??.?#?.? 2,2,3",
"?????#.?###???.???#. 5,3,1,2,1",
"##?.????#??.? 3,1,3,1",
"??##?..?.??????##??? 4,1,7",
".#?.?#..##?# 1,2,2,1",
"????#?#???# 3,4,1",
"#????#?????#.?? 1,1,8,1",
"?.??#???#??#?#???..? 1,5,4,1,2,1",
"?????.???????. 2,6",
"?#.???##..#? 2,4,2",
"????##????# 2,3,3",
"??##?????????####? 2,12",
"?.????????????.. 1,1,7,2",
"?.##?.?.?#.???#???#? 1,2,1,8",
"###???.####???. 3,1,4,2",
"???..??#??#.???? 1,6,1",
".???#??#.????????? 7,3,3",
"?#?????#???#??? 5,8",
"?#.??#???? 1,1,2",
"?.?#?#???..#.? 1,5,1,1",
".??????#?? 1,1,4",
"????#???????? 3,2",
"????????#?.?.???#? 7,1,1,1,3",
"?#??????.?????#??#? 3,3,1,1,1,2",
"?#??.?.??.?? 2,1,1,1",
"?????????? 1,3,1",
".???#????# 1,2,3",
"?#??.#????#?#?. 1,8",
".?#?#?##??.?#? 1,5,3",
"#?.?.??#????#???#? 1,1,4,2,3",
"#..##.#?## 1,2,4",
"##???#?#???.??.?? 3,7,1,1",
"???###?????#???. 5,7",
".#?.?.?#?#..??##.?? 1,1,3,4,1",
"?.#.?????. 1,1,1",
"???#?#??#?????.? 2,2,6",
"?.??????.#.. 1,1,2,1",
"???????#?. 1,1,1",
"??.?..##???#?? 1,7",
"???.?????## 1,3",
"..????.?##?.. 3,2",
"?#.#.?###???.?#??? 2,1,5,1,4",
"#??##.?.?.????? 1,3,1,2",
".????.?#???? 2,4",
".?##??##??.?. 3,4,1",
"#???.?#??#? 2,6",
"????????#?#????. 4,2,1,2",
"??#??.#???? 1,2,1",
"??#?????#??.??? 10,1,1",
"??????.?#? 1,3,2",
"..#?.?????? 1,2,1",
"#.????###??.??#???? 1,1,6,1,1,2",
"?????#???#?. 2,2",
"??.?#???.????. 1,1",
"..?...?#?? 1,3",
"???.??????#??? 1,1,4,2",
".????.??.???#### 3,1,5",
"?????#.??#.#? 5,1,1,1",
".??.????????.?#??? 3,2",
"??.?#?.??.??? 1,2,1,1",
"??#?..??#. 1,2",
"?????.??#?? 3,1,3",
"?.#?..?#?###. 1,2,6",
"?###?##?.?#..???#?.? 7,1,1,2,1",
"???#?????????????? 6,1,3,3",
"??.?##??.?? 2,4",
"??.?#?###???..#?? 6,2",
"#?????????##??? 1,1,8,1",
"??????.?.# 2,1,1",
"#?.?##?????#?? 2,3,5",
"??#??#?.???? 1,1,2,3",
"..#?.????#?????#?##? 2,1,6,4",
"?????#???#??#???? 1,1,1,4,5",
"????..?#??? 1,3",
".#?????????????# 3,1,9",
"?##?#????????.?##?? 12,4",
"????.?#????.#?.# 1,1,5,2,1",
"????????#?##.?#? 3,7,3",
"?#?.?##?.?# 2,2,1",
".#???#????.??# 1,6,1",
".???.??????#? 2,6",
"??##??????#??#?#.?## 1,6,1,3,2",
"?###??????#???##? 5,9",
".?.?.????#??# 1,1,3,1",
".?????..???? 4,3",
"?#????#?.????? 1,1,2,3",
"?.???????.???.??? 1,2,3,2",
"#??#..#####? 4,6",
"?..?#????#???#?#? 1,2,3,3",
"?????????? 2,1,1",
"?.????.#??#??.##?? 1,3,2,1,1,4",
"#?????#?.? 2,4,1",
"????.??#?#???? 1,6",
"???#?##????#?#??. 12,1",
"???#??????#?#?#????? 8,4,2,1",
".???#?..???#??.?. 1,4",
"??#.#?????.#?##? 1,1,3,1,5",
)
