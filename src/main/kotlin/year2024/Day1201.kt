package year2024

import kotlin.coroutines.suspendCoroutine
import kotlin.math.abs

fun main() {
    val parsed = realinput12.map { it.split("").filter {it.isNotEmpty()}}

    val distinct = parsed.flatten().toSet()

    val regionsByLetters = hashMapOf<String, ArrayList<ArrayList<Pair<Int, Int>>>>()
    val prices = arrayListOf<Int>()
    for (letter in distinct) {
//        if (letter != "C") continue
        // оце о хуйня
//        val coords = parsed.mapIndexed { indexY, strings ->
//            strings.mapIndexed { indexX, s ->
//                if (s == letter) {
//                    Pair(indexY,indexX)
//                } else {
//                    Pair(-1, -1)
//                }
//            }
//        }.flatten().filter {it.first != -1 && it.second != -1}
        var regions = arrayListOf<ArrayList<Pair<Int, Int>>>()
        var region = arrayListOf<Pair<Int, Int>>()
        var debugCounter = 0
//        parsed.for

        parsed.forEachIndexed { baseY, strings ->
            strings.forEachIndexed { baseX, s ->
//                if (s == letter) {
//
//                } else {
//                    Pair(-1, -1)
//                }
                if (!regions.flatten().contains(Pair(baseY,baseX)) && s == letter) {

                    region.add(Pair(baseY,baseX))
                    for (c in 0..(parsed.size-1) * (parsed[0].size-1)) {
                        for (y in 0..parsed.size - 1) {
                            for (x in 0..parsed[0].size - 1) {
                                if (regions.flatten().contains(Pair(y, x))
                                    || (y == baseY && x == baseX) || parsed[y][x] != letter
                                ) {
                                    continue
                                } else {
                                    if (
                                        (region.any { abs(it.first - y) == 1 && abs(it.second - x) == 0 })
                                        ||
                                        (region.any { abs(it.second - x) == 1 && abs(it.first - y) == 0 })
                                    ) {
                                        if (!region.contains(Pair(y, x)))
                                        region.add(Pair(y, x))
                                    }
                                }
                            }
                        }
                    }
                    debugCounter = debugCounter +1
                }
                if (region.isNotEmpty()) {
                    region.distinct()
                    region.sortBy { it.second }
                    region.sortBy { it.first }
                    println("$letter - $region")
                    regions.add(region)
//                println("$letter - $regions")
                    region = arrayListOf<Pair<Int, Int>>()
                }
            }
        }
        regionsByLetters[letter] = regions
        regions = arrayListOf()

//        println("$letter - $coords")
//        val minY = coords.map { it.first }.min()
//        val minX = coords.map { it.second }.min()
//        val maxY = coords.map { it.first }.max()
//        val maxX = coords.map { it.second }.max()
//
//        val area = coords.size
//        val perimeter = (maxY - minY +1)*2 + (maxX - minX +1)*2
//
//        println("$letter - $area - $perimeter")
    }
    println("------------------")
    println(regionsByLetters)
    println("------------------")

    regionsByLetters.keys.forEach {letter ->
//        println("$letter - ${regionsByLetters[letter]}")

        regionsByLetters[letter]?.forEach { coords ->
                    val minY = coords.map { it.first }.min()
        val minX = coords.map { it.second }.min()
        val maxY = coords.map { it.first }.max()
        val maxX = coords.map { it.second }.max()

        val area = coords.size
//        val perimeter = (maxY - minY +1)*2 + (maxX - minX +1)*2
            var perimeter = 0
            for (point in coords) {
                val top = (if (coords.contains(Pair(point.first - 1, point.second))) 0 else 1)
                val bottom =(if (coords.contains(Pair(point.first + 1, point.second))) 0 else 1)
val left =   (if (coords.contains(Pair(point.first, point.second - 1))) 0 else 1)
        val right =       (if (coords.contains(Pair(point.first, point.second + 1))) 0 else 1)
                perimeter = perimeter + top + bottom + left + right


            }
//                .sum().let { perimeter ->
//                println("$letter - $area - $perimeter - $coords")


        val price = area * perimeter
        prices.add(price)
        println("$letter - area $area - perimeter $perimeter - price $price")

        }
    }

    println("result 1 = ${prices.sum()}")

}

val sampleInput12 = arrayListOf(
    "AAAA",
            "BBCD",
            "BBCC",
            "EEEC",
)
val sampleInput122 = arrayListOf(
    "OOOOO",
            "OXOXO",
            "OOOOO",
            "OXOXO",
            "OOOOO",
)
val sampleInput123 = arrayListOf(
    "RRRRIICCFF",
            "RRRRIICCCF",
            "VVRRRCCFFF",
            "VVRCCCJFFF",
            "VVVVCJJCFE",
            "VVIVCCJJEE",
            "VVIIICJJEE",
            "MIIIIIJJEE",
            "MIIISIJEEE",
            "MMMISSJEEE",
)

//+ R - area 12 - perimeter 18 - price 216
//- C - area 15 - perimeter 32 - price 480
//A region of C plants with price 14 * 28 = 392.
//A region of C plants with price 1 * 4 = 4.
//+ S - area 3 - perimeter 8 - price 24
//+ E - area 13 - perimeter 18 - price 234
//+ F - area 10 - perimeter 18 - price 180
//+ V - area 13 - perimeter 20 - price 260
//- I - area 16 - perimeter 28 - price 448
//- I - area 2 - perimeter 6 - price 12
//+ J - area 11 - perimeter 20 - price 220
//+ M - area 5 - perimeter 12 - price 60

val realinput12 = arrayListOf(
    "XXXXXUUUNNNNNNNNNNNNNNNNQQQQQQQQQJJJJJJJJJJJJJJJJCCCAAAAAAAAAAAAOVVVVVVVVVVVVVVVVVVLLLLLLLLKKKKGGGGGGGGGGGGGGGGGGGKKKKKKKKKKKKKKKKKKKKKKKKKK",
            "XXXUXXUUUUNNNNNNNNNDNNDGQQQQQQQQQJJJJJJJJJJJJJJJJJJCCCAAAAAAAAAYVVZVVVVVVVVVVVVVVVVVLLLLLLLLKKKGGGGGGGGGGGGGGGGGGGKKKKKKKKKKKKJKKKKKKKKKKKKK",
            "XUUUUUUUUUENNNNNNNNNNNDCCCCCCCCQQJJEJJJJJJJJJJJJJJCCAAAAAAAAAAAZZZZVVZVVVVVVVVVVVVVVLLLLLLLLKGGGGGGGGGGGGGGGGGGGGKKKKKKKKKKKKAKKKKKKKKKKKKKK",
            "UUUUUUUUUUUYNNNNNNNNNNNCCCCCCCCQJJJJJJJJJJJJJJJJJJCAAAAAAAAAAAAZZZVVVVVVVVVVVVVVVVVVLLLLLLLLLLZGGGGGGGGGGLLGGGGGGKKKKKKKKKKAAAAKKKKKKKKKKKKG",
            "UUUUUUUUUKKNNNNNNNNNNZZCCCCCCCCJJJJJJJJJJJDDJJJJJJCAAAAAAAAAAAAHZZVVVVVVVVVVVVVFVVMVVLLLLLLLLLMAAAGGGGLLGLLGGGGGGGGGKKKKKKKAAAAKKKKKKKKKKKKG",
            "UUUUUUUUUKUANNNNNNNNNZZCCCCCCCCQJJJJJJJJJDDDDJJJJJCJJAAAAAAAAAAHZZVVVVVVVVVVVVVVVVMMLLLLLLLGLLMAAAAGGGLLGLLLLLLLGGGGKKKKKKKAAAAKKKKKKKKKKKKG",
            "UUUUUUUUUUUUUNNNNNNNNZZCCCCCCCCQQQQJJDDDDDDDDDJJJJJJAAAAAAAAAAAZZZVVVVVVVVVVVVVVVVMMLLLLLLGGGMMAALGGGLLLLLLLLLLLGGGKRKKKKKKAPPPPPKKKKKKKKKKG",
            "UUUUUUUUUUUUNNNNNNNNNZZCCCCCCCCCCCCCCCCCDDDDDDJJJJJJAAAAAAAAZZZZZZZVVVVVVVVVVVVVVVMMMLLLLLGGGMAAALLLLLLLLLLLLLLLKKKKKKKKKKKPPPPPKKKKKKKKKGGG",
            "UUUUUUUUUUUZNYNNSNNNNZZCCCCCCCCCCCCCCCCCDDDDDDEJJJJJAAAAAAAAAZZZZZZVVVVVVVVVVVVVVVMMMLLLLLGMMMMMALJLLLLLLLLLLLLLKKKKKKKOKPKPPPPKKKKKKGGKGGGG",
            "UUUUUUUUUUUZNSNZZZZZZZZCCCCCCCCCCCCCCCCCDDDDDDJJJJJAAAAAAAQAAAZZZZZZZMFMMMMMMMMMMMMMMMLLLGGMMMMMMMLLLLLLLLLLLLLLKKKKKKKKPPPPPPPPKKPKKGGKGGGG",
            "UUUUUUUUUUMSSSZZZZZZZZZCCCCCCCCCCCCCCCCCDDDDDJJJJJJAAAAAAAQZZZZZZZZZZFFMFMMMMMMMMFFMMLLLLGAMMMMMMMMMLLLLLLLLLLLLLKKKKKKPPPPPPPPPKKPKKGGGGGGG",
            "UUUUUUUUUMMSSSZZZZZZZZZCCCCCCCCCCCCCCCCCDDDJJJJJJJJJAAJAAQQZZZZZZZZZZFFFFMMMMMMMMFIAMMAAAAAMMMMMMMMLLLLLLLLLLLLLLKFKKKKEPPPPPPPPPKPKGGGGGGGG",
            "OOUUUUUUSSSSSSZZZZZZZZZCCCCCCCCCCCCCCCCCDDDJJJJJJJJJJJJAAQQNNNZZZZZZZFFFFFFFFFFFFFFAAAAAAAAMMMMMMMMXLLLLLLLLLLLLKKUUUUUPPPPPPPPPPPPPPPGGGGCC",
            "OUUUUOUUUPSSSSZZZZZZZZZZZZZZZQQCCCCCCCCDDSDDCJJJJJJJJAAAAAQNZZZZZZZZZFFFFFFFHFFFFFFFAAAAAAAAMMMMMMCCCLCLLLLLLLLLLTUUUUUPPPPPPPPPPPPPPPPGGGCC",
            "OOUGGGGUUSSSSZZZZZZZZZZXXXXJJJJJJCCCCCCDDSSCCJJJJJJJJAAAAANNNNZZZZZBPPFFFFFFFFFFFFFFAAAMAAAAAMMMMMMCCCCCLLLLLLLLLMMUUUPPPPPPPPPPPPPPPPPGGGCC",
            "OGGGGGGLLLLSSZZZZZZZZZZXXXJJJJJJJCCCCCCSSSSSJJJJJJJJJJJAAANNNNNZZZNPPPPFFGPPFFFFFFFAAAAMAAMMAMMMMMMCCCCCCOOOLLLLLLMMUUUPPPPPPPPPPZPPPPCCCCCC",
            "OGZZGGGLLLLLSZZZSSSXXXXXXXXXJJJJJCCCCCCSSSSWJJJJJJJJJJPJANNNNNZZZNNPPPPPFPPPPPFFFVHHAAMMMMMMMMMCMCICCCCCCCCOOLTOOLMMMUUPPPPPPPZPPZPCCICCCCCP",
            "OGGGGGGGGLLSSZZZSSSXXXXXXXXXJJJJJCCCCCCSSSSSJJJJJJJJJJJJNNNNNZZZZZNNPPPPPPPPPPPVVVVVMMMMMMMMMMCCCCCCCCCCCOOOOOOOOOMMUUUUPPPPPZZZZZZCCCCCCCCP",
            "SGGGGGGGGLSSSZZZSXXXXXXXXXXJJJJJJCCCCCCJSSSRJJJJJJJNJJJNNNNNNNZZZNNPPPPPPPPPPPPVVVVVMVMMMMMMMCCWCCCCCCCCCCCOOOOOOOOOUUUUPPPPPNNZZZCCCCCCCCCP",
            "SGGGGGGGSSSSSZZZSUXXXXXXXJJJJIJJJCCCCCCJWWWWJJJJJJJJLJJNNNNNNNNNNNNNPPPPPPPPPPPVVVVVVVMMMMMCCCCCCCCCCCCCCCCCCOOOOOOOUUUPPPPPPNNNNCCCCCCCCCPP",
            "SSSGGGGGGGVSSSSSUUXXXXXXXJJJIIJJJCCCCCCWWWWWJJJJJJJJJJNNFNNNNNNNNPPPPPPPPPPPPPVVVVVVVMMMMMMMRRRRCCCCCCCCCCCCCOOOOUOOUUUPUTNNNNNNNCCCCCCCPCPP",
            "SSSSZGGGGGRYSSSRXXXXXXXXXXJJJJJJJJJJJJWWWWWWWJJAJJJJJNNFFNNNNNNNNPPPPPPPPPPPPPVVVVVVVMMMMMMMMRRRCCCCCCCCCCCCCOOOOUUUUUUUUTNNNNNNNNCCCCCCPPPP",
            "SSSZZGHGGGRRJSRRGXXXXXXXXXXJJSSJJJJJJJWWWWWWWJJAJJJJJJFFNNNNNNNNNNPPPPPPPPPPPPPVVVVVVMMMMMMMRRRRRCCCCCCCCCCCCOOOUUUUUUUUUTTTTTNNNNNCCCCPPPPP",
            "SSQQZZGGGGRRRRRRRXXXXXXXXRXRRJJJJJJJJWWWWWWWWWJJJJJJJJJFFFFFFNNANNNPPPPPPPPPVVVVVVVVVMMMMMRRRRRRRCLLCLLLLLCCCCOOOUUUUUUUTTTTTTNNPPNCCPPPPPPP",
            "QQQQQZZGGGRRRRRRRXXXXXRRRRRRRRJJJJJJWWWWWWWWWWWWWJJJJFFFFFFFFAAAAAPPPPPPPPPVVVVVVVVVVVVDMMMRRRRRRRLLLLLLLLCLCLOOUUUUUUUUUUUUUUUPPPPPPPPPPPPP",
            "QQQQZZQQZRRRRRRRRRRRRRRRRRRRRRRJJJJJSWWWWWWWWWWWWWJJJFFFFFFFFAAAAAPPPPPPPPVVVVVVVVVVVVDDMDRRRRRRRRXXXXLLLLLLLLUOUUUUUUUUUUUUUUUPXPPPPPPPPPPP",
            "QQQQQQQQQRRRRRRRRRRRRRRRRRRRRRRRJVJSSWWWWWWWWWWWWWFFFFFFFSFAAAAAAAPAPPPPPPVVVVVVVVVVDVDDDDRRRRRRRRLXLLLLLLLLLLUUUUUUUUUUUUUUUUUUXXPPPPPPPPPP",
            "QQQQQQQQQRRRRRRPRRRRRRRRRRRRRRRRVVWWWZWWWWWWWWWWWWJFFFFFFFAAAAAAAAAAVPPPPPVVVVVVVVVVDDDDDDHRRRRRRELLLLLLLLLLLSSUUUUUUKUUUUUUUUKUXPPPPPPPPPPP",
            "QQQQQDQDGRSPRPPPPRRRRRRRRRRRRRRRRVVVWWWWWWWWFFJJJJJJJJJFFAAAAAAAAAAAAAPPVVVVVVVVVVVDDDDDDRRRRRRRRRRRLLLLLLLLLLSUUUUUKKKUUKKKUUKUUPPPPPPPPPPP",
            "QDDQDDQDGGPPPPPPPRRRRRRRRRRRRRRRRVVWWWWWWWWWDFFJJFFFFJJFFAAAAAAAAAAAAAAPVVVDDVVVVVDDDDDDDRRRRRRRRRRRLLLLLLLLLSSSUUSUUKKKKKKKKKKUYYPPPPPPPPPP",
            "QDDDDDDDGPPPPPPPPRRRRRRRRRRRRRRRRVVVVWWWWWQQFFFJFFFFFFFFFAAAAAAAAAAAAABBHDDDDVVDVDDDDDDDDRFRRRRRRRRLLLLLLLLLLLSSSSSSKKKKKKKXXDYYYYYPPPPPPPPP",
            "DDDDDDDGGGPWPPPPPPPPRRRRRRRRRRRRRRVVVWWQQWQQQFFJFFFFFFFFAAAAAAAAAAAAAUBBHBBBDDDDDDDDDDDDDDRRRRRRRRRLLLLLLLLLLSSSSSSSKKKKKKKKXDYYYYYPYPPPPPPP",
            "DDDDDDDDDGPWPPPPPPPPPRRRRRRRRRRRRRVRWWWWQQQQQFFFFFFFFFZFAAAAAAAAAAAAABBBBBBBBBBDDDDDDDDDDDDDYRRRRRRRLLLLLLLJLLSSSSSSKKKKKKKKXDDDYYYYYYYPPPKP",
            "DDDDDDDDDDDDPPPPPPPPPRRRRRRRRRRRRRRRRSSQQQFFFFFFFFKKFFFHHHAAAAAAAAAAABBBBBBBBBBBDDDDDDDDDDDDRRRRRRLLLLLLLLSSSSSSSSSUKKKKKKKKDDDDYYYYYYYPPPPY",
            "DDDDDDDDDDAAPPPPPPPPPRRRRRRRRRRRRRRRSSQQQEEGFFFFHHFFFFHHHHAAAAAAAAABBBBBBBBBBBBBDDDDDDDDDDDDRRRRRRRLLLHHLLLSSSSSSSSSKKKKKKGGDDDDDDYYYYYPPPYY",
            "DDDDDDDDDDAAAPPPPPPPPPRRRNNRRRRRRRRSSQQQQEEEFFFHHHHHFHHHHHHHAAAABBBBBBBBBBBBBBBBBDDDDDDDDDRRRRRRRRRLLLHHHLSSSSSSSSSSKKKKKKDDDDDDDDYYYYYYYYYY",
            "DDDDDDDDDDDAAPPPPPPPPRRRNNNRRRRRRRQQSQQQQEEEFFFHHHHHHHHHHAAAABBBBBBSSBBBBBBBBBBBBDDDDDJJJJDDRRRRRRRHLLHLLLLSSSSSSSSKKKKKKKUDDCDDDDYYYYYYYYYY",
            "DDDDDDDDDDAAAPPPPPIIIRRRRNRRRRRRRRQQQQQQQEEEFFFHHHHHHHHHHHHAABBBBBBBBYBTBBBBBKBRBDDDDJJMMJJDRRSSRRRHLHHHHHLQQQSSSSSSKKKKKKDDDDDDDYYYYYYYYYYY",
            "DDDDDDDDDDDAAPPPPPPQIIIRRRRRRRRRRQQQQQQNNQEHHFFFHHHHHHHHHHHHHBBBBBBBYYYBBBBBBBBRRRRDDJJJJJJRRRRRRRHHHHHHJJLQQQSQQSSSSSSKKKDDDDDDDYYYYYYYYYYY",
            "DDDDDDDDNNDQAPPPPPQQQIIRQRRRRRRRRRQQQQQQNNSHHFHHHHHHHHHHHHHHHBDBBBYYYYYBBBBBBRRRRTDDJJJJJJJTRRRRRRHHHHHHHQQQQQQQQSSSSSSSDDDDDDDDDYYYYYYYYYYY",
            "DDDDDDDDNNNQAPPNPPPQQIIQQHRRRRRRRRQQQQQQQNSHHHHHHHHHHHHHHHHEHBDDGBBGWWWBBBBBBBRRRTTTTJJJTTTTRHHHHHHHHHHHHHQQQQQQQSSSSSSSSSDDDDDDYYYYYMYYMYYY",
            "DDDDDDDNNNNQQQPPQQQQQQQQQHHHHHXXXXXQQQQQQNNNHHXXHHHHHHHRRHRRRRDDGBBGWWWWBBBWWBRRRTTTTTTTTTTTTHHHHHHHHHHHHQQQQQQQQSJJSSSSSSSDDDDDYYMYMMMMMMYM",
            "DDDIIDDDDNNQQQQPQQQQQQQQQQHHHXXXXXQQQQQQQNNEEEHHHHHHHHHRRRRRRRGGGGGGWEWWWBBWWBWWWWRTTTTTTTTTHHHHHHHHFHHLQQQQQQQQQQJJJSSSSDSDIIDDYYMMMMMMMMYM",
            "DDDDDDDHNNNNQQQQQQQQQQQQHHHHXFXXXXXXXNNNNNNNNHHHHHHHHHHRRRRRRUUGGGGGGGGWWWWWWWWWWWRRTTTTTTTHHHHHHHHFFHGQQQQQQQQQJJJJJJSSSDDDIIYYYYMMMMMMMMMM",
            "QDDDDNNNNNNNNQQQQQQQZZQQQHHXXXXXXXXXXNUNNNNNNNNPNYYHHHRRRRRRRRUGGGGGGGGWWWWWWWWWWWWWTTTTCTTTHHHHHHHHHGGGQQQQQQQJJJJJVJWSWKKKYIYYYYYMMMMMMMMM",
            "QDDQNNNNNNNNNNNQQQQQZZLQHHXXXXXXXXXNNNNNNNNNNNNNNNYHHHRRRRRRRRRGGGGGGGWWWWWWWCWWWWCWTTTTCCTCHHHHHHGGHGGQQQQQQQJJJJJJVWWSWKKKYYYYYYYYMMMMMMMM",
            "QQQQNNNNNNNNNQQQQQQQZZZZZXXXXXXXXXTNNNNNNNNNNNNNNNNNHHRRRRRRRGGGGGGGGGGWWWWCCCWWWCCQQCCCCCCCHVHHHHHGGGGQQQQQQQJJJJJJJWWWWWKKKQYYYYMMMMMMMMMM",
            "QQQNNNNNNNNNNNQQQQQQQZZZZLXUWXXXXXNNNNNNNNNNNNNNNNNKKHRRRRRRRGGGGGGGGGGWWWCCCCCCCCCQQQCCCCCCVVVVVDDGGGQQQQQQQQJJJJJJJWWWWWLKLQQYQQNMMMMMMMMM",
            "QQQQNNNNNNNNNNQQQZZZZZZZZZOWWXWXXWNNWNNNNNNNNNNNKKKKKKARRRRRRGGGGGGGGGGGWWWCCNCCCCCCQCCCCCCCCVVVVDGGGGKOQOKKQJJJJJJJWWWWWWLLLQQQQMMMMMMMMMMM",
            "QQQNNNNNNNNNNNNQZZZZZZZZZZZZWWWWWWNWWWNNNNNNNNNNKKKKKKARRRRKKKKGGGGGGGGGGWWWCCCCCCCCCCCCCCCCCCVDDDDDGGKOOOKKQQJJJJJWWWWWWLLLLMQQQMMMMMMMMMMU",
            "LQQQNNNNNNNNNNQQZZZZZZZZZTTTTWTWWWWWWWNNNNNNNNNNNKKKKKARRRRKKKKGGGGGGGGGWWWUCRCCCCCCCCCCCCCCJDDDDDDGGKKKKKKKKKJJJJJWWWWWWMLLLMQQTMMMMMMMMMMM",
            "LNNNNNNNNNNNNQQQZZZZZZZZTTTTTWTWWWWWWWNNNNNNNNNNKKKKKKARRRRDKKKKKKGGGGGGWGUUCCCCCCCCCCCCCCCUCCDDDDDGDKKKKKKKKKJJJJTTTWWWMMMMMMMMMMMMMMMMMMMM",
            "LLNNNNNNNNNNNNQQZZZZZZZZTTTTTTTTWWWWWWWNNNNNNNNNNKKKKKKGGRRDDKKKKKKKKGGGGGUUUUCCCCCCCCCCCCCCCCDDDDDDDNKKKKKKKKKKJYYTTTTMMTTMMMMMMMMMMMMMMMMM",
            "LLLNTNNNNNTNQNQQCCZZZZZTTTTTTTTTWWWWWWWNNNNNNNNNNKNNKKKGGRRRDDKKKKKKKUGGGUUUUUCCCCCCCCCCCCCCCCDDDDDNNNNNKKKKKKKKBYYTTTTMTTTTTTMMMMMMMMMMMMMM",
            "LLLLTTNNNNTTQQQQQQZZZZTTNTTTTTTWWWWWWNNNNNNNNNNNNGGGGKGGGGGCDKKKKKKKKUGGUUUUUCCCCCCCCCCCCCCCCCDDDDDDNNNNKKKKKKKKKYYTTTTTTTTTMMMMMMMMMMMMMMMM",
            "LLLLLTNNNNTTQTQQTTTTTTTTTTTTTTTWWWWWWWNNNNNNNNNNNNGGGGGGGCCCCCKKKKKKUUUUUUUVUCCCCCCCCCCCLCCCCCDDDDDDDDDDKKKKKKKKYYYTTTTTTTTTNNNMMMMMMMKKMMMM",
            "LLLLLTNNNNTTTTQTTTTTTTTTGTTTTTKKKWKKKWNNNNNNNNNNNNNGGGGGGGCCCCKKKKKKUUUUUUUVVCCCCCCCCCCLLCEECCDDDDDDDDDKKKKKKKYYYYYTTTTTTTTNNNNNKKKKKKKKKKKK",
            "LLLLLTTTNNTTTHBTHTTTTTTTGTTTTKKKKKKKKWNNNNNNNNNNNNNGGGGGGGXCCCCKKKKKUUUUUUZVVCCCCCLCCLLLLLLEDDDDDDDDDDDKKKKKKKYYYYYTTTTTTTTTENNNKKKKKKKKKKKK",
            "LLLLLLLTTTTHHHHHHHTTTTTGGTGKKKKKKKKKKWWNNNNNNNNNNNGGGGGGGGCCCCKKKBBKUVVVVZZVCCCCFFLLLLLALZBDDDDDDDDDDDDKKKKKKKYYYYYTTTTTTTNNNNNNNKKKKKKKKKKK",
            "TTTTTTLTTTHHHHHHHHHTTTTTGGGKKKKKKKKKKWWGNNGNNNNNNNNNGGGGGGCCCCCKKKCCUVVVVVVVVVCFFFFLLLLAZZZZZDDDDDDDKKKKKKKKYYYYYYYYTTTTTTNNNNNNNKKPKKKKKKKK",
            "TTTITTTTTTHHHHHHHHTTTTTTGGKKKKKKKKKKKGGGGGGNNNNNNNNNNGGGGCCCCCCCCCCCUUUVVVVVVVVVVFFLLLLAAZZZZZDVDDDKKKKKKYYYYYYMYYTTTYTTTTTNNNNNNNKKKKKCKKKN",
            "TTIIIIIIIIIIIIIHHHTTTTTTTACKPKKKKKKPKGGGGGGGNNNNNNNNNGGGGCCCCCCCCCCCCUUVVVVVVVVVVVRHHLLLZZZZZZZZDKKKKKKKKYYYYYYMMYYYYYYTTTNNNNNNNNNKKKKKKKNN",
            "TTTIIIIIIIIIIHHHHHHTTTTTAAKKKKKKKKPPPGGGGGGGGGNGGNNNNGGGXCCCCCCCCCCCCCCVVVVVVVVVVVRRRRRLLZZZZZZZDZZZKKMMKMMYMMMMMMYYYYYYYYNNNNNNNNNNNNKKNNNN",
            "TTIIIIIIIIIIIIPHAATTTTTAAAUKKKKKTPPPGLLGGGGGGGGGNNNKKKGXXXKCCCCCCCCCCVVVVVVVVVVRRRRRREEZZZZZZZZZZZZZKKMMMMMMMMMMMMYYYYYYYYNNNNNNNNNNNNNNNNNN",
            "TTIIIIIIIIIIIIIIAAATTTAAAUUUKKTTTTPPGGGGGGGGGGGSKKKKKKKXXXCCCCCCCCCCVVVVVVVVVVVVRRRRRRRZZZZZZZZZZZZZKKMMMMMMMMMMMYYYYYYYYYYNNNNNNNNNNNNNNNNN",
            "IIIIIIIIEEEIIIIIAAAAAAAAUOUUKKJTTTPPGGGGGGGGGGGSKKKKKKXXXXCCUCCCCCCCVVVVVVVVVVVVRRRRRRRZZZZZZZZZZZZZKMMMMMMMMMMMMMYYYYYYYYYYNANNNNNNNNNNNNNN",
            "EERIIEEEEEBEIIIAAAAAAAUUUUUUUUJJTTTJJJGGGGGGGGGGGKKKKKXXXXXXCCCCCCCCVVVVVVVVVVRRRRRRFRRZEZZZZZZZZZZZKKKMMMMMMMMMMMYYYYYYYZZZZZZZNNNNNNNNNNXX",
            "EEEIIEEEEEEEEEEEEAAAAUUUUWWNUUJJTTTTJGGGGGGGGGGGGKKKKXXQXXXQCCCCCQCCVVVVVVVVVRJJRRRRRRRZEEEZZZZZZZZKKKMMMMMMMMMMMMYYYYYTTZZZZZZZNNNNANTNNXXX",
            "EEECEEEEEYEEEEEAEAAAAUULLWWWWLTTTTTTTGGGGGGGGGGGGKKKKKKQXQQQCCQCQQCCVVVVVVVVRRRRRRRRRRRRERRZZZZUZKKKKKHMMMMMMMMMPMMTTTTTTZZZZZZZAANNATTXXXXR",
            "EEECEEEEEEEEEEJAAAAAAAUOOOOWWLLTTTTVGGGGGGGGGGGKKKKKKKKQQQQQQQQQQQCCCVVVVVKKRRRRRRRRRRRRRRIPBZZUZKKKKHHMMMMMMMMMMTTTTTTTTZZZZZZZAANNAARRRRRR",
            "EEEEEEEEEEEEEEAAAAAAAAUOOOOWWLLLQUTVGGGGGGGGGGKKKKKKKKKQQQQQQQQQQQQCVVVVVVKKKRRRRRRRRRRRRIIPPPPPPKKKKHHHHMMMMMMMMMTTTTTTTZZZZZZZAAANARRRRRRR",
            "EEEEEEEEEEEEEEEVAAAAAAPOOOOLLLLQQQLQGGGKGKKKKGTTKKKKKKKQQQQQQQQQKQQCCVVVVVKKKRRRRRRRRRRRRRPPPPPLPKKHHHHHHMMMMMMMMMTTTTTTTTOAZZZZAAAAAARRRRRR",
            "EEIEEEEEEEEEEEEEAAAAAAOOOLLLLQQQQQQQGGQKKKKKKEETTKKKKKQQQQQQQKKKKQQQVVVVVKKKKRRRRRRRRRRRRPPPPPPPPHHHHHHHHMMMMMMOMOTTTTTTTTHAZZZZAHAAARRRRRRR",
            "CEIEEEEEEEEEEEEEAAAAAAALLLLLLQQQQQQQGGQKKKKKKEETEKKWWKQQQQQQKKKKKKQKKVVKKKKKKKKKKKKKRRRRRPPPPPPPPPHHHHHHHHMMMMMOOOOTTTTTTCCCCCCCCCAAARRRRRRR",
            "BBBBEEEEEEEEEEAAAAAAAAAALLLQQQQQQQQQQQQQQQQKKEETEEWWWQQQQQQKKKKKKMKKKVVKKKKKKKKKKKKKRBRRHVHHPPPPPPHHHHHHHMMMMMMMMMTTTTTTTCCCCCCCCCAAAARRRRRR",
            "BBBEEEWEEEEEEEEEAAAAAAAALLLQQQQQQQQQQQQQQKKKKEEEEEWWWWWQQQQKKKKKKKKKKKKKKKKKKKKKKKKKRBKRHHHHPPPPPPRHHHHHRQMIMMMMMQTTTTTTTCCCCCCCCCHRRRRRRRRR",
            "BBBBEEEEEEEEAAAEAAAAAAAALLQQQQQQQQQQQQQQKKEEEEEEEEWWWWWWWKKKKKKKKKKKKKNKKKKKKKKKKKKKKKKRHHHHPPPPPPPHHHHHQQVMMMMPPTTTTTTTTCCCCCCCCCHRRRRRRRRR",
            "BBBBEEHEEEEEAAAAAAAAAAALLLSZQQQQQQQQQQQQQQEEEEEENEEWWWWWKKKKKKKKKKKKKNNKNNCKKKKCKKKKKKKHHHHHPPPPPPPHHHHHQQQLMMMMPPTTTTTTTCCCCCCCCCOORRRRRRRR",
            "BBHHHHHHEAAEAAAAAAAAAAAALLSZQQQQQQQQQQQQQQEEEEEEEEEEHWWWKKKKKKKKKKKKKKNKNNCCCCCCCCKKKKKKHHHHHHPPPPDHHSSHQQLLLLMPPPTTTTTTTCCCCCCCCCOORRRRRRRR",
            "BBHHHHAHEAAAAAAAAAAAAAAAASSZQQQQQQQQQQQQQUEUEEEEEEEHHWWWWEKKKKKKKKKKKKNNNNCCCCCCCCKKKKKKHHHNNHPPPPPHHSSQQQLLMMMPPPTTTTTTTCCCCCCCCCOOOOORRRRF",
            "BBHHHHAAAAAAASSAAAAAAAAAYSSSSQQQQQQQQQQQUUUUUEEEBEHHEEEEEEEKKKKKKKKKKKKKNNCCCCCCCCKKKKHHHHHNNNXPPPPHHSSQQLLMMMMPMPPTTTTTTOOOOHHOOOOOOOOORRRR",
            "BBHHHHHHAAAASSSAAAAAAAYYYYSSSSSQQQQQQQQQQUUBBBBBBBHHHHEEEEEKKKKKKKKKKKKKNCCCCCCCCCCKKHHHHHNNNXXRRPXHSSSQQLMMMMMMMPPTTTTSZZOOOOOOOOOOOOOOORDD",
            "BBHHHHHJJAAAASSSSSSSYAAYYYYSSSQQQQQQQRQQQUUUUUBBBBBHHHEEEEEEEEEKKKKOOZCZNCCCCCCCCCCKKKHHHHNNNXXXXXXXSSSMSSMMMMMMMPPTTTTTZZOOOOOOCOOOOOOOOOOD",
            "HJHHHHJJJJAAASSSSSSSYYYYYYYYYYQQQRQQQRRRUUUUBBBBBBBBHHEEEEEEEXXXXXXXZZZZZCCCCCCCCCCCCHHHNNNNXXXXXXXSSSSSSMMMMMMMMWPTTTTZZZZOOOOOCOOOOOOOOOCO",
            "HHHHHJJJJJSSSSSSSSSSYYYYYYYYYRRQRRRRRRRRUUUUBBBBBBBBBHHHEEEEEXXXXXXXZZZZZCCCCCCCCCCCCCHHHNNNRXXXXXSSSSSSSSMMMMMMWWPTTTTZMZZZOOCCCCOOOOOOOOOO",
            "HHHHJJJJJJJSSSSSSSSSSYYYYYYYYRRRRRRRRRRRUUQUUBBBHHBBHHEEEEEEWXXXXXXXZZZZZCCCCCCCCCCCCCCCHPPNNXXXSSSSSSSSSSMMMMMMWWWTTTTTZZZZCCCCCCCCOOOOOUOU",
            "HJJHJJJJJJJMSSSSSSSSSSYYYYYYYYRRRRRRRRRRRUQUUHHBHHBHHHHEEEWWWXXXXXXXZZZZZCCCCCCCCCCCCCYYCPPPPPSSSSSSSSSSSSMMMMMMWWMTTTTTZCCCCCCCCCCCOOUUUUUU",
            "JJJJJJJJJJJJJSSSSSSSSSSYYYYYYYRRRRRRRRRRQQQQHHHHHHHHHHHEEEWWXXXXXXXXZZZZZCCCCCCCCCCCCCCCCPPPPPSSSSSSSSSSSMMMMMMMMMMMTTTTZCCCCCCCCCCCQCUUUUUU",
            "JJJJJJJJJJJJJSSSSSSSIISYYYYYYYRRRRRRRRRRRPQQQHHHHHHHHHHEEHHWXXXXXXXXZZZZZKKNCCCCCCCCCCPPPPPPPPSSSSSSSSSSMMMMMMMMMMMMMTTTTCCCCCCCCCCCCCUUUUUU",
            "JJJJJJJJJJJJJSSSSIIIIIIYYYYRRRRRRRRRRRRRRPPQPPHHHHHHHHHHEEHWXXXXXXXXZZZZKKKKKKCCCCCCCOPPPPPPPPPPSSSSSSSSMMMMMMMMMMMMMTTTTCCCCCCCCCCCCUUUUUUU",
            "JJJJJJJJJJJPPPIIIIIIIIYYIIIRRRRRRRRRRRRCCPPPPHHHHHHHHHHHHHHHXXXXXXXXZZKKKKWKKKKCCCCCPPPPPPPPPPPASSSSSSSSSKMMMMMMMMMMMTTTTTCMCCCCCCCCCUUUUUUU",
            "JJJJJJJJJJJQIIIAAAAAAAAIIEEEREBRRRRRRRRCCPCPCYHHHHHHHHHHHHHHXXXZQZZZZZKCCKKKKKKKKKCQQQQQQQQPPPPSSSSSSSSSMMMMMMMMUMMHHTTTTTTMMCHCCCFCUUUUUUUU",
            "JJJJJJAAAAAAAAAAAAAAAAAAAAAARRBRRRRRRCCCCCCCCYHHHHHZHHHHHHHSXXXZZZZZZZKCCKKKKKKKKKWQQQQQQQQPPPPPSSSSSSSSSSMMMMMMMHHHHTTTTTTMMCHCCCUUUUUUUUUY",
            "QJJJJJAAAAAAAAAAAAAAAAAAAAAABBBBBBBRRRRCCCCCBHHHZZHZZHHHHHMSXXXSZZZZZCCCKKKKKSKKWKWQQQQQQQQPCCPSSSSSSSSSSSMMHHHMHHHHHTTHTTTMHHHCFCUUUUUUUUUY",
            "QJJJJJAAAAAAAAAAAAAAAAAAAAAABBBBBBBBRRRRCCCEBEHHZZZZHHHHHHMSXXXSSZZZCCCCCKKKKKKWWWWQQQQQQQQGCCCCSSSSSSSSSSHHHHHHHHHSSSTHTVVMHHUUFFFUUUUUYUUY",
            "AAAAAAAAAAAAAAAAAAAAAAAACCBBBBBBBBBBRRRCCCCEEEEZZZZZHHHHHHMSXXXSSSZSSCCCCKKKKKKWWWWQQQQQQQQCCCCCCCESSSSSSSSHHHHHHHHSSSHHHHVVUUUUUFUUUUUYYUYY",
            "AAAAAAAAAAAAAAAAAAAAAAAACCBBBBBBBBBBBRRRDCSBEBEEEZZZZZHHHHMSXXXSSSSSSSSCCKOKWKWWWWWQQQQQQQQQQQQCCEEEESVSSEHHHHHHHHHSSHHHHHVVUUUUUUUUUUUUYYYY",
            "AAAAAAAAAAAAAAAAAAAAAAAACBBBBBBBBBBBBBRRDDBBBBBEEEXXZZHMMMMMSPPPSSSSWWWKKKKKWWWWWWQQQQQQQQQQQQQCEEEEEEEEEEHHHPHHHHHHHHHHHVVUUUUUUUUUUUUUYYYY",
            "AAAAAAAAGGGGGGAAAAAAAAAABBBBBBBBBBTBTBDDDDBBBBBBBEHHHHHMPPPPPPPPSSSWWWWKWKKWWWWWWQQQQQQQQQQQQQQEEEEEEEEEEEHHHHHHHHHHHHHHHVVVVUUUUUUUUUUUYYYY",
            "AAAAAAAAGGGGGGAAAAAAAAAABBBBBBBTTBTTTMDDDDBBBBBBBBHHHHMMPPPPPPPPPPPPPPWWWWWWWWWWWQQQQQQQQQQQQQQEEEEEEEEEEEEHHHHHHHHHHHHHVVVVVUUUUUUUUUHHYYYY",
            "GGGGGGGGGGGGGGAAAAAAAAAAZBBBBBBTTBTTTTTDDDBRBBBBBBHHHMMMPPPPPPPPPPPPPPWWWWWWWWWCWQQQQQQQQQQQQQQPPPPEPPPEEEEXHHHHHHHUHVVHVVVVVVUUUUUUHHHHHHHY",
            "GGGGGGGGGGGGGGAAAZZZZZZZZBBBTTTTTBTTTTTDDDDBBBBBBBHHHMMJPPPPPPPPPPPPPPKWWKKWWWCCCQQQQQQQQQQQQQQPPPPPPXXXXXEXXIXXXHUUVVVVVVVVVVUUUUUUUHHHHHHH",
            "GGGGGGGGGGGGAAAAAZZZZZZZZBBBTTTTTTTTTTTTTDDBBBBBBBHHHHMJPPPPPPPPKKKKKKKWKKKKWWCCCQQQQQQQQQQQQQQPPPPPPXXXXXXXXXXXUUUUVVVVJJVVVVVVVUVUUHHHHHHH",
            "GGGGGGGGGGGGAAAAAAAZZZZZZZRRRTTTTTTTTTTTLBBBBBBBBBBBMMMJPPPPPPPPKKKKKKKKKKCCCCCCCQQQQQQQQQQQQQQQQQQPPXXXXXXXXXXXXUUUUUVJJJJJJVJVVVVVVHHHHHHH",
            "YYGGGGGGGGGGAAAAAAAZZZZZZZZRRTTTTTTTTTQTLBBBBBBBBBBMMMMJPPPPPPPPPKKKKKKKKKCCCCCCCQQQQQQQQBBQQQQQQQQPPXXXXXXXXXYXXUUUUJVJJJJJJJJVVVVVHHHHHHHH",
            "YYGGHGGGGGGGAAAAAAZZZZZZZRRRTTTTTTTTTTQQBBBBBBBBBBBBBBMJPPPPPPPPPKKKKKKKKKCCCCCCCQQQQQQQQBBQQQQQQQQPPPXXXXXXXXXUUUUUUJPJJJJJJJVVVVVVVHHHHHHH",
            "YYPGHGGGGGGHADDAAAWZZZZZZZZRRTTTTTTTTTQQBBBBBBBBBBBBEEMJPPPPPPPPPKKKKKKKKKCCCCCCCQQQQQQQQBBGGGPPPPPPPPXXXXXXXXXUUUUUUJJJJJJJJJVVVVVHHHHHHHHH",
            "PPPPHHHHGGGHHHMAAAAZZZZZHHHTTTTTTTTTTTQQBBBBBBBBBBOBOEMJJJJJJJKKKKKKKKKKIICCCCCCCCCCCCCBBBBGGGGHPPPPPXXXXXXXXXXUUUUUJJJJJJJJJCJJVVVVHHHHHHHH",
            "PPHHHHHHHGGHMMMMMMMZZZHHHHHTTTTTTTTTTTTTTTBBBBBBBOOOOOWJJJJJJJJJJJJJJKKKIICCCCCCCCCCCCCBBBBGGGGGWLLLLXXXXXXXXXXUUUJJJJJJJJJJTJJJJVUUUHHHHHHH",
            "HHHHHHHHHHHHMMMMMMMMMZHHHHHHTTTTTTTTTTTTTEBBBBBBBBBOOOWJJJJJJJJJJJJCCCCCCCCCCCCCHCCCCCCBBBBGGGSLLLLLLXXXXXXXXXXXUUUUUJHHJJJJJJJJJJUUUUHHHHHH",
            "HHHHHHHHHHHHSMMMMMMMMZHHHHHHHHTTTTTTTTEEEEEEBBBBBBBBOOWJJJJJJJJJJJJCCCCCCCCCCCCCCCCICCVBBBBLLLLKKKKKKKKKKKKKKKUUUUULLLHHJJJJJJJJUUUUUUHHHHHH",
            "HHHHHHHHXHDHSMMMMMMMMMMHHHHUHTTTTTTTTTEEEEEEHHDBBBBDOOLWLLLLJJJJJJJCCCCCCCCCCCCCICCIMHHBBBBKLLLKKKKKKKKKKKKKKKXXULUULLJJJJJJJJJUUUUUUUUHHHHH",
            "HXXXHHHHHHHHMZMMMMMMMMMHUUUUUWTTTTTTTTEEEHEEHDDBBDDDOLLLLLLLJJJJJJJCCCCCCCCCCCCIIIIIIKKBBBBKLLLKKKKKKKKKKKKKKKXILLLLLLLJJJJJJJUUUUUUUUUUUHHH",
            "HHXQXXXXHHQQMMMMMMMMMMUHUUUUUWBTTTTTNBBEHHHHHDDDDDDDLLLLLLLLJJJJJJJCCCCCCCCCCCIIIIIIIKKKKLLLLLLKKKKKKKKKKKKKKKXIILIILLIJJJJJJUUUUUWWWUUUHHHH",
            "HXXXXXNNHHQQQMMMMMMMMUUUUUUUUBBTTBBBBBBEEHHHHDDDDDSDLLLLLLLLJJJJJJJCCCCCCCCCCCIIIIIIIIKKLLLLLLLKKKKKKKKKKKKKKKXIIIIIIIIIJJJJJUUUUUWWWWWWWWWH",
            "XXXXXXXNNNXQCCCCCMMMDUUBUUUUUUBBBBBBBBBEEHHHHHHHSDSDDDDLDLLCJJJJJJJCCCCCCCCCCCJIIIIIIIIKKKKLLLLKKKKKKKKKSUXIIIIIIIIIIIIIJJJJJJUUUWWWWWWWWWWH",
            "XXXXXXXXXXXXCCCCCCCDDUUUUUUUUUBBBBBBBBBBEHHHHHHHSSSSDSSSDDNNJJJJJJJCCCCCCCCCCCJIIIIIIIIIKKKLLLLKKKKKKKKKRSIIIIIIIIIIIIIIIIJJJJUUUWWWWWWWWWHH",
            "XXXXXXXXXXXXCCCCCCCIDUUUUUUUUUUBBBBBBBBBBDDHHHHSSSSSSSSSSDDDNNNNNNNCCCCCCCCCCCJIIIIIIIHIIKLLLLLLSSSSSSSSSSIIIIIIIIIIIIIIIDDJJDDUUUWWWWWWWWHH",
            "XXXXXXXXXXXXOCCCCCCIDUUUUUUUUUUBBBBTTBBBBDDSSHSSSSSSSSSSSSSNNNNNNNNNCCCCCCCCCCJJJJIIIHHHHLLLLLLSSSSSSSSSSSIIIIIIIIIIIIIDIIDJJDDDUUWWWWWWWWWW",
            "XXXXXXXXXXXXOOHHHHHIIIIUUUUUUUUUBBBNTBNBDDSSSSSSSSSSSSSSSPPPNNNNNNNNCCCCCCCCCCJJJHHHHHHHHLLLLLLSSSSSSSSSSSSIIIIIIIIIIIIDDIDDDDDDDDDWWWWWWWWW",
            "XXXXXXXDXXXXXOHAHHHHIIUUUUUUUUUUBBBNNNNNSSSSSSSSSSSSSSSPPPPPNNNNNNNNCCCCCCCCCCJJJHHHHHHHHLLLLLLSKSSSSSSSSSSIIIIIIIIIIIIIDDDDDDDDDDWWWWWWWWWW",
            "XXKXXXXDDXXOOOHHHHQHWIIUUUUUUUUUUGGGNNNNNNNSSSSSSSSSSQHQPPQQQNNNNNNNCCCCCCCCCCJJJJHHHHHHHHHLLLLLSSSSSSSSSIIIIININIIIIIIDDDDDDDDDDDDWWWWWWWWW",
            "NXXTXXTTTXXOOOHHHHHHHIIUUUUUUUUUUGEGNNNNNNNSSSSSSSSSSQQQQPQQQQQQNNNNCCCCCCCJJJJJCJHHHHHHHLHLLLLLVVSSSSSSSIIIINNNNIIIIIIDDDDDDDDDDDDWWWWWWWWW",
            "XXTTTTTTTTOOOOHHHHHHHIIIUUUWMUUUUJGGNNNNNNPPSSPSSSSSQQQQQQQQQQQQNNNNNNNJJJJJJJJJJJHHHHLLLLLLLLLLVVSSSSSYYYINNNNNNICIIIIDDDDDDDDDDDWWWWWWWWWW",
            "TXTTTTTTTTTOFFFHHHHIIIIIUWWWWWWUWGGGNNNNNNPPSPPPSSSSQQQQQQQQQQQQQNNNNNNJJJJJJJJJJJHHHHLLLHLLLLLLSSSSSSSSSYNNNNNNNCCCCICDDQQQQPDDDDYWWWWWWWWW",
            "TXTTTTTTTTTOIJFFHHHIIIIIWWWWWWWWWWWGWNNNPPPPPPPPSSSQQQQQQQQQQQQQNNNNNNNNJJJJJJJJJJJJHHHHLHHHLLHYYYSSSSSYYYNNNNNCCCCCCCCQQQQQQQDDDDDWWWWWWWWS",
            "TTTTTTTTTTTTIFFFIHIIIIWWWWWWWWWWWWWWWNUPPPPPPPPPSSSQQQQQQQQQQQQNNNRNNNNNJJJJJJJJJJJHHHHHHHHHHLHYYYSSYSSYYYYYNNNCCCCCCCCCQQQQQQDDDIIWWWWWWWWS",
            "TTTTTTTTTTTTIIIIIIIIIWWWWWWWWWWWWWWHHHUPPPPZPPPPPSSQQQQQQQQQQQQNNRRNRRRRFFFFJFFJJHHHHHHHHHHHHHHHYYYYYYYYYYYYYNNCCCCCCCQQQQQQQDDIIIIWJWWWXWWW",
            "TTTTTTTTTTTTIIIIIIIIIWWWWWWWWWWWWWHHHHUPPPPPPPPPPPPPLLQQQQQQQQQQRRRRRRRRFFFFFFFFHHHHHHHHHHHHHHHHHYYYYYYYYYYYAANDCCCCCCCQQQQIIIIIIIIWJWWWXWWW",
            "TTTTTTTTTTTTIIIIIIMMIUWWWWWWWWWWWWHHHHUPPPPPPPPPPPPPQQQQQQQQQQAARRRRRRRRRFFFFFHHHHHHHZZHHHHHHYYYYYYYYYYYYYYYAAAAACCCCCCCCHYYIYIITIIWWWIWWWRQ",
            "TTTTTTTTTTTTTIIIIIMYWWWWWWWWWWWHHHHHHHHPPPPPPPPPPPPPQQQQQQQQQQAQRRRRRRRRRRFFHHHHHHHHZZZZHHHHHYEEYEYYYYYYYYAAAAAACCCCCCCCCCCYIYIITTIIIIIWIIRQ",
            "TTTTTTTTTTTTBIIIIIMMMMWWWWWWWWWWHHHHHHHHZPPPPPPPPPOOQQQQQQQQQQQQTRRRRRRRRRRRHHHHHHRZZZZZZPHHHYEEEEEYYYYYYYYYAAAACCZOOCCCCCCYYYIITIIIIIIIIRRQ",
            "TTTTTXXXBTVVJIIIIIMMMWWWWWWWWWWHHHHHHHHHPPPPPPPPPPPOQQQQQQQQQQQQTTRRRRRRRRHHHHHHHZZZZZZZPPEEEEEEEEYYYYYYYYYAAAAZZZZOOOOCCCCCTTTTTTTTTIIIIIRQ",
            "TTTTXXXXXXJVJJIIIMMMWWWWWWWWWWHHHHHHHNHHPPPPPPPPPPPOOOOOQOQQQQQOOTORRRRRRRRRHHHHZZZZZZZZEEEEEEEEEYYYYYYYYYYYYAAZEZZZOOOOCCCCCTTTTTTTTTTTTTRR",
            "TTTXXXXXJJJVJJIIIIMVVVWWWWWWWHHHHHHHHHHHOPPPPPPPPOPOOOOOOOOQQOOOOOORRRRRRRHHHHHHHZZZZZZZYEEEEEEEYYYYYYYYYYYYYKAEEZZZOOOOOOIITTTTTTTTTTTTTTRR",
            "TXXXXXXYYJJJJIIIIIIVVVWWWWWWWHHHHHHHHHHHOPPOPPOPOOOOOOOOOOQQQOOOOOORRRRRHHHHHHHHHZZZZZZYYEEEEEEEEEIYYYYYYYYYYKKTEEEEOOOOOOITTTTTTTTTTTTRRRRR",
            "TXXXXXXXYJJJJJIJIIIVVVVWWWWWWHHHHHHHHHHOOOOOPOOOOOOOOOOOOOOQOOOOOOORRRRRHRHHHHHHHHHZZZZYYYYEEEEEEEYYYYYYYYYOOKKKEEOOOOOOOOITTTTTTTTTTTTRRRRR",
            "TXTXXXXXYYJJJJJJVVVVVVWWWWWWWWHHHHHHHHHHOOOOOOOOOOOOOOOOOOQQOOOOOOORRRRRRRHHHHHHHHHHHHZYYYEEEEEEEYYYYYYYYYYOOOOOOOOOOOOOOOIITTTTTTTTTTRRRRRR",
            "TTTXXXXXXXJJJJJVVVVVVVVVWWWWWWHFFFFFFFHHHOOOOOOOOOOOOOOOOOOQOOOOOQORRRRRRRHHHHHHHHHHHHHHYYEEEMEEMMYYYYYYYYYYOOOOOOOOOOOOOOIIITTTTTTTTRRRRRRR",
            "TTTXXXXXXZZZJJJVVVVVVVVVWWWWWWFFFFFFFHHLOOOOOOOOOOOOOOOOOOOOOOOOOOORRRRRRRHHHHHHHHHHHHHHYYEEMMMMMYYYYYYYYYYOOOOOOOOOOOQOIIIIITTFFTTRRRRRRRRR",

)