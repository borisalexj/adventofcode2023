package year2024

//val results = arrayListOf<Pair<Int, Int>>()
//val results = hashMapOf<Pair<Int, Int>, ArrayList<Pair<Int, Int>>>()
fun main() {
    val parsed = realInput10.map { it.split("").filter { it.isNotEmpty() }
        .map { if (it.toString()==".") -1 else it.toInt() }
        }

    parsed.forEach { println(it) }


    parsed.forEachIndexed { indexY, line ->
        line.forEachIndexed { indexX, pos ->
            if (pos == 0) {
//                println("Start")
                recursion(parsed, indexY, indexX, value = 0, startY = indexY, startX = indexX)

            }
        }
    }

    println("----------------")
//    results.size.let { println(it) }
//    results.filter { it.first != -1 && it.second != -1 }.size.let { println(it) }
    results.keys.sortedBy { it.second }.sortedBy { it.first }.forEach {key ->
//        println("$key - ${results[key]?.toSet()?.size} - ${results[key]?.toSet()}")
        println("$key - ${results[key]?.size} - ${results[key]}")
    }
    results.keys.size.let { println("trailheads - $it") }

    results.keys.map {key ->
        results[key]?.size ?: 0
    }.sum().let { println(it) }


}

val sampleInput1022 = arrayListOf(
    ".....0.",
"..4321.",
"..5..2.",
"..6543.",
"..7..4.",
"..8765.",
"..9....",
)

val sampleInput1023 = arrayListOf(
    "..90..9",
"...1.98",
"...2..7",
"6543456",
"765.987",
"876....",
"987....",
)
val sampleInput1024 = arrayListOf(
    "012345",
    "123456",
    "234567",
    "345678",
    "4.6789",
    "56789.",
)
val sampleInput1025 = arrayListOf(
    "89010123",
    "78121874",
    "87430965",
    "96549874",
    "45678903",
    "32019012",
    "01329801",
    "10456732",
)

//fun recursion(parsed: List<List<Int>>, indexY: Int, indexX: Int, value: Int, startY: Int, startX: Int,) {
////    println("$indexY $indexX  - $value")
//    if (parsed.getOrNull(indexY)?.getOrNull(indexX) == 9 && value == 9) {
////        println("success")
//        val tempRes = results.get(Pair(startY, startX))
//        if (tempRes == null) {
//            results[Pair(startY, startX)] = arrayListOf(Pair(indexY, indexX))
//        } else {
//            tempRes.add(Pair(indexY, indexX))
//            results[Pair(startY, startX)] = tempRes
//        }
//        return
//    }
//
//    var tempY = indexY
//    var tempX = indexX +1
//    if (parsed.getOrNull(tempY)?.getOrNull(tempX) == value +1 ) {
//        recursion(parsed, tempY, tempX, value+1, startY, startX)
//    }
////    tempY = indexY +1
////    tempX = indexX +1
////    if (parsed.getOrNull(tempY)?.getOrNull(tempX) == value +1 ) {
////        recursion(parsed, tempY, tempX, value+1, startY, startX)
////    }
//    tempY = indexY +1
//    tempX = indexX
//    if (parsed.getOrNull(tempY)?.getOrNull(tempX) == value +1 ) {
//        recursion(parsed, tempY, tempX, value+1, startY, startX)
//    }
////    tempY = indexY +1
////    tempX = indexX -1
////    if (parsed.getOrNull(tempY)?.getOrNull(tempX) == value +1 ) {
////        recursion(parsed, tempY, tempX, value+1, startY, startX)
////    }
//    tempY = indexY
//    tempX = indexX - 1
//    if (parsed.getOrNull(tempY)?.getOrNull(tempX) == value +1 ) {
//        recursion(parsed, tempY, tempX, value+1, startY, startX)
//    }
////    tempY = indexY -1
////    tempX = indexX -1
////    if (parsed.getOrNull(tempY)?.getOrNull(tempX) == value +1 ) {
////        recursion(parsed, tempY, tempX, value+1, startY, startX)
////    }
//    tempY = indexY -1
//    tempX = indexX
//    if (parsed.getOrNull(tempY)?.getOrNull(tempX) == value +1 ) {
//         recursion(parsed, tempY, tempX, value+1, startY, startX)
//    }
////    tempY = indexY -1
////    tempX = indexX +1
////    if (parsed.getOrNull(tempY)?.getOrNull(tempX) == value +1 ) {
////         recursion(parsed, tempY, tempX, value+1, startY, startX)
////    }
//}
//
//val sampleInput10 = arrayListOf(
//    "...0...",
//"...1...",
//"...2...",
//"6543456",
//"7.....7",
//"8.....8",
//"9.....9",
//)
//val sampleInput102 = arrayListOf( // correct 4
//    "..90..9",
//"...1.98",
//"...2..7",
//"6543456",
//"765.987",
//"876....",
//"987....",
//)
//
//val sampleInput103 = arrayListOf( // correct 3
//    "10..9..",
//            "2...8..",
//"3...7..",
//"4567654",
//"...8..3",
//"...9..2",
//".....01",
//)
//val sampleInput10larger = arrayListOf(
//    "89010123",
//    "78121874",
//    "87430965",
//    "96549874",
//    "45678903",
//    "32019012",
//    "01329801",
//    "10456732",
//)
//
//val realInput10 = arrayListOf(
//    "654329854329876510123231016987212010510218565101234510343",
//    "789218765010945678754122987878900123424309654345679623490",
//    "543201698541232789669003456987210874535698701234388701581",
//    "650165467432871694578712012076321965549785698323897632672",
//    "569870346501960543209873453125409876678012587610432543543",
//    "678761250123451632114562164534012761237703476526501105412",
//    "879610167245893101023470079643443450349812345457432236903",
//    "965673298436734345652981188712565621056789400348901247894",
//    "434789567823321238761892199801874872341019511289187656785",
//    "323458478910210679850743056765923985432678521898096105016",
//    "012367320154301589012656145678910676563565430787145234127",
//    "121032110263469874322347238765876545612346541256230873298",
//    "678545021378954365411038389054985434501487632344321964343",
//    "569956985489565243506789872123010123676598701015423459652",
//    "654877676671278152105698143232131010989687772356910598701",
//    "123468964510189067834521032143328325678567887447827654323",
//    "003457853031656508921432541089419834509413996530988921013",
//    "012346322142347210560210654076508543210302105421243219034",
//    "329855412456898723874345789123467658723213489439850108123",
//    "410765001387129634987606932345358169654654398701763237654",
//    "567892187298034545674517801776549015456765217652304565456",
//    "103011296106234589503623410887232102367896900343215694347",
//    "234520345787105678212896556992185601298787871298344787298",
//    "309639876496221218923287647881096520109696678987650120156",
//    "018743212345430307832100238941087412368543567676543210347",
//    "329651008758745476542321107632101309454322430125210321298",
//    "478010129669876589401498210543291298765011321212345696212",
//    "566723234554745654320567641874980787012780876503856787101",
//    "345814656765634765210198532965673236323498903454945671012",
//    "210905549876589894321983449452360145324567612367834589323",
//    "356876632365565923015892158301450765410212143256521985434",
//    "547893421245674310234765067201221896784301032103410676965",
//    "432012560634789212105604300104334985895212349874306565876",
//    "101765676543434301789812215419455854326710458213215678945",
//    "569858987612343890176543216328766733210824567303764549432",
//    "478945890502345789265674307435432145601939665432876732981",
//    "323832781981256776328989438976965032789348778901905891070",
//    "210501632870125865410676521089874321011657345877814560565",
//    "343412541065434934541541078789289010150069256766923471234",
//    "454323401298743327601232369632103210541178129845812984321",
//    "565216543345652418796543454543432325652298087234701005630",
//    "074307232387651009187452330346501478743367896100565216787",
//    "189898101997843218012341021257562569895456545321074323896",
//    "234798001876960107345987012368876521080303434538989010143",
//    "145667010165456256296456543879989437871212343245698763230",
//    "021054323234387340187898534987654306965105650156787654321",
//    "430032104101298712345657659654789215456016781235673212452",
//    "545145235310132101076740348743690104312167098767654101963",
//    "696236996232145098889821289634587431203458129868910017876",
//    "587347887145096567986798678723876520104239234776521149887",
//    "678956981076787057872107509018987011015145445689432234796",
//    "454965438987789142963456410123070187676076323432011005645",
//    "567870127695654231254784321212165296589889916501123010434",
//    "458765476554514340345697654301254345432127807867834121125",
//    "389654389453001234434398941210345452345076321958985034016",
//    "210323430302112965525289030367676321456985430843476985107",
//    "323014321210227871012100123458983210167890121652105876898",
//
//)