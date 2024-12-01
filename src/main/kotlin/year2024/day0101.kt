package year2024

import kotlin.math.abs

fun main() {
        val start = System.currentTimeMillis()
    val parsedInput =
        realInput01.map {
            Pair(Item(it[0], false), Item(it[1], false))
         }
    sampleInput01.forEach { println(it) }
    parsedInput.forEach { println(it) }

    var res = 0

    while (true) {
        val smallestLeft = parsedInput
            .filter { !it.first.processed }
            .minBy { it.first.number }

        val smallestRight = parsedInput
            .filter { !it.second.processed }
            .minBy { it.second.number }

            println("---------------")

        smallestLeft.first.processed = true
        smallestRight.second.processed = true

//        val posLeft = parsedInput.indexOfFirst {
//            it == smallestLeft
//        }
//
//
//        val posRight = parsedInput.indexOfFirst {
//                               it == smallestRight
//                           }

        println("$smallestLeft - $smallestRight")
        println("${abs(smallestLeft.first.number - smallestRight.second.number)}")
        res = res + abs(smallestLeft.first.number - smallestRight.second.number)

        if (parsedInput.all { it.first.processed == true}) {
            break
        }
    }

    println("result - ${res}")

           val finish = System.currentTimeMillis()
           println("time - ${finish - start}")


}


val sampleInput01 = arrayListOf(
    arrayListOf(3,   4),
    arrayListOf(4,   3),
    arrayListOf(2,   5),
    arrayListOf(1,   3),
    arrayListOf(3,   9),
    arrayListOf(3,   3),

)


val realInput01 = arrayListOf(

arrayListOf(80784,   47731),
arrayListOf(81682,   36089),
arrayListOf(22289,   41038),
arrayListOf(79525,   17481),
arrayListOf(62156,   70590),
arrayListOf(87975,   21561),
arrayListOf(54635,   59542),
arrayListOf(43393,   99451),
arrayListOf(45310,   59542),
arrayListOf(18324,   92078),
arrayListOf(36887,   79481),
arrayListOf(35723,   48782),
arrayListOf(78420,   35875),
arrayListOf(93307,   52649),
arrayListOf(77342,   80601),
arrayListOf(69125,   47895),
arrayListOf(37292,   20025),
arrayListOf(45553,   59542),
arrayListOf(27412,   30010),
arrayListOf(67708,   70822),
arrayListOf(92078,   91109),
arrayListOf(48367,   87581),
arrayListOf(26852,   30538),
arrayListOf(42123,   17859),
arrayListOf(20067,   87581),
arrayListOf(20239,   32262),
arrayListOf(50660,   73585),
arrayListOf(46240,   45533),
arrayListOf(29502,   46131),
arrayListOf(77080,   36089),
arrayListOf(64180,   14043),
arrayListOf(74942,   72085),
arrayListOf(73979,   22860),
arrayListOf(47999,   41397),
arrayListOf(36014,   35101),
arrayListOf(39827,   32262),
arrayListOf(81418,   86581),
arrayListOf(47467,   14538),
arrayListOf(65923,   46584),
arrayListOf(95054,   17500),
arrayListOf(59680,   37730),
arrayListOf(94609,   19539),
arrayListOf(33451,   39467),
arrayListOf(69173,   12422),
arrayListOf(31769,   34255),
arrayListOf(85180,   29056),
arrayListOf(82104,   52296),
arrayListOf(90955,   38171),
arrayListOf(83927,   70590),
arrayListOf(59455,   17306),
arrayListOf(28681,   86581),
arrayListOf(54107,   13789),
arrayListOf(79824,   21386),
arrayListOf(53890,   46519),
arrayListOf(94883,   87581),
arrayListOf(12797,   46584),
arrayListOf(66809,   24306),
arrayListOf(78327,   24086),
arrayListOf(19780,   43234),
arrayListOf(55623,   38171),
arrayListOf(10937,   42288),
arrayListOf(24262,   74556),
arrayListOf(92076,   77080),
arrayListOf(69179,   15029),
arrayListOf(13764,   52214),
arrayListOf(92187,   63803),
arrayListOf(91328,   94609),
arrayListOf(24356,   36089),
arrayListOf(82974,   84225),
arrayListOf(55924,   70822),
arrayListOf(65439,   55383),
arrayListOf(78097,   82069),
arrayListOf(58045,   12422),
arrayListOf(72087,   37730),
arrayListOf(70822,   32262),
arrayListOf(78511,   48368),
arrayListOf(39251,   54157),
arrayListOf(74623,   59542),
arrayListOf(32104,   74623),
arrayListOf(69499,   17481),
arrayListOf(97919,   33260),
arrayListOf(37778,   74623),
arrayListOf(56977,   14684),
arrayListOf(19100,   98708),
arrayListOf(29453,   34463),
arrayListOf(18839,   87581),
arrayListOf(75434,   75839),
arrayListOf(58303,   84225),
arrayListOf(84924,   24108),
arrayListOf(99813,   37730),
arrayListOf(99218,   93749),
arrayListOf(54262,   38470),
arrayListOf(61773,   94274),
arrayListOf(67034,   56935),
arrayListOf(71788,   74556),
arrayListOf(83455,   22604),
arrayListOf(76089,   84225),
arrayListOf(11003,   85999),
arrayListOf(80814,   62471),
arrayListOf(41928,   56000),
arrayListOf(52541,   71034),
arrayListOf(37488,   53519),
arrayListOf(78475,   33260),
arrayListOf(57117,   32449),
arrayListOf(54543,   54732),
arrayListOf(19050,   52775),
arrayListOf(80967,   76950),
arrayListOf(71045,   29497),
arrayListOf(61189,   43136),
arrayListOf(75055,   38171),
arrayListOf(91573,   46131),
arrayListOf(50100,   70590),
arrayListOf(46554,   24973),
arrayListOf(25154,   99579),
arrayListOf(19853,   77080),
arrayListOf(11807,   20266),
arrayListOf(40158,   24315),
arrayListOf(92543,   38171),
arrayListOf(93300,   87581),
arrayListOf(79628,   68978),
arrayListOf(19164,   51702),
arrayListOf(53719,   96515),
arrayListOf(38074,   46503),
arrayListOf(25693,   53188),
arrayListOf(79321,   17481),
arrayListOf(25108,   21108),
arrayListOf(38398,   72487),
arrayListOf(22073,   59542),
arrayListOf(98191,   39605),
arrayListOf(80619,   66029),
arrayListOf(99138,   74556),
arrayListOf(49897,   33260),
arrayListOf(84225,   10112),
arrayListOf(14331,   66948),
arrayListOf(94603,   36089),
arrayListOf(33642,   75862),
arrayListOf(14314,   89669),
arrayListOf(12998,   48362),
arrayListOf(10989,   21312),
arrayListOf(68074,   46131),
arrayListOf(10531,   47636),
arrayListOf(32312,   70590),
arrayListOf(66844,   38171),
arrayListOf(73563,   77034),
arrayListOf(33099,   65439),
arrayListOf(93734,   71747),
arrayListOf(56538,   35101),
arrayListOf(55501,   82069),
arrayListOf(19974,   94609),
arrayListOf(21308,   23592),
arrayListOf(37062,   36089),
arrayListOf(99908,   59542),
arrayListOf(92651,   94321),
arrayListOf(81371,   84225),
arrayListOf(96268,   35101),
arrayListOf(58685,   25444),
arrayListOf(37191,   86819),
arrayListOf(71956,   87899),
arrayListOf(28341,   70822),
arrayListOf(11995,   64983),
arrayListOf(92426,   70590),
arrayListOf(30515,   57117),
arrayListOf(72193,   37685),
arrayListOf(82150,   77080),
arrayListOf(19292,   73860),
arrayListOf(52076,   53020),
arrayListOf(26135,   78522),
arrayListOf(49482,   79269),
arrayListOf(56103,   81747),
arrayListOf(62006,   66781),
arrayListOf(41905,   24906),
arrayListOf(23782,   10112),
arrayListOf(39865,   41627),
arrayListOf(80074,   91781),
arrayListOf(84213,   70822),
arrayListOf(19586,   43155),
arrayListOf(87133,   70822),
arrayListOf(67811,   65439),
arrayListOf(60019,   23478),
arrayListOf(29057,   70590),
arrayListOf(77349,   16491),
arrayListOf(32372,   13789),
arrayListOf(93055,   65439),
arrayListOf(82209,   30330),
arrayListOf(75731,   60775),
arrayListOf(91276,   79848),
arrayListOf(90330,   37730),
arrayListOf(41180,   59542),
arrayListOf(81204,   95937),
arrayListOf(36092,   11620),
arrayListOf(13033,   38171),
arrayListOf(34488,   51306),
arrayListOf(71770,   81668),
arrayListOf(37630,   57117),
arrayListOf(87608,   69809),
arrayListOf(90593,   59542),
arrayListOf(52792,   39467),
arrayListOf(33508,   46226),
arrayListOf(78150,   29434),
arrayListOf(18072,   84225),
arrayListOf(11205,   63803),
arrayListOf(28801,   39467),
arrayListOf(89617,   47552),
arrayListOf(91269,   77080),
arrayListOf(50829,   15405),
arrayListOf(96387,   68582),
arrayListOf(44407,   46131),
arrayListOf(17491,   74556),
arrayListOf(77464,   57117),
arrayListOf(67053,   71830),
arrayListOf(67048,   20722),
arrayListOf(15369,   76996),
arrayListOf(71812,   74803),
arrayListOf(96980,   35466),
arrayListOf(39993,   82069),
arrayListOf(65498,   59148),
arrayListOf(88138,   79430),
arrayListOf(16497,   54357),
arrayListOf(75624,   46131),
arrayListOf(84028,   39464),
arrayListOf(82572,   39122),
arrayListOf(14297,   36089),
arrayListOf(33805,   85723),
arrayListOf(44778,   74556),
arrayListOf(14498,   87581),
arrayListOf(71384,   17116),
arrayListOf(47173,   82069),
arrayListOf(60652,   82069),
arrayListOf(67241,   46316),
arrayListOf(73276,   80192),
arrayListOf(46786,   68313),
arrayListOf(88795,   97650),
arrayListOf(95120,   23939),
arrayListOf(53010,   82069),
arrayListOf(40256,   82069),
arrayListOf(26913,   71782),
arrayListOf(44746,   88309),
arrayListOf(49866,   86581),
arrayListOf(50951,   97892),
arrayListOf(80832,   30492),
arrayListOf(22643,   70822),
arrayListOf(84334,   86581),
arrayListOf(96028,   70590),
arrayListOf(39816,   56848),
arrayListOf(78427,   63379),
arrayListOf(27147,   92078),
arrayListOf(35658,   12422),
arrayListOf(76747,   47552),
arrayListOf(32896,   59542),
arrayListOf(98898,   12422),
arrayListOf(45166,   37081),
arrayListOf(38602,   27009),
arrayListOf(17507,   82069),
arrayListOf(75567,   74623),
arrayListOf(71921,   29970),
arrayListOf(11800,   90710),
arrayListOf(23973,   68582),
arrayListOf(80315,   68252),
arrayListOf(86659,   13782),
arrayListOf(23014,   71633),
arrayListOf(33041,   57117),
arrayListOf(93351,   65439),
arrayListOf(69088,   46584),
arrayListOf(71994,   91050),
arrayListOf(61532,   98835),
arrayListOf(98790,   76392),
arrayListOf(62890,   75035),
arrayListOf(37723,   36089),
arrayListOf(56136,   20455),
arrayListOf(91663,   84225),
arrayListOf(76413,   87581),
arrayListOf(89223,   11659),
arrayListOf(33477,   47973),
arrayListOf(34541,   16506),
arrayListOf(82603,   59542),
arrayListOf(37730,   75791),
arrayListOf(25272,   98835),
arrayListOf(86703,   82248),
arrayListOf(56755,   54948),
arrayListOf(74556,   92078),
arrayListOf(11337,   36089),
arrayListOf(52534,   27174),
arrayListOf(60327,   87581),
arrayListOf(84554,   89264),
arrayListOf(11381,   59542),
arrayListOf(99601,   81999),
arrayListOf(20139,   33278),
arrayListOf(25530,   59558),
arrayListOf(97414,   74906),
arrayListOf(11269,   70822),
arrayListOf(66500,   13789),
arrayListOf(23195,   68582),
arrayListOf(22872,   53300),
arrayListOf(94937,   51202),
arrayListOf(12273,   55687),
arrayListOf(63364,   71074),
arrayListOf(14160,   15554),
arrayListOf(57473,   39467),
arrayListOf(19091,   87899),
arrayListOf(43286,   16810),
arrayListOf(25975,   33571),
arrayListOf(57319,   39467),
arrayListOf(61075,   66766),
arrayListOf(95980,   98826),
arrayListOf(47190,   55086),
arrayListOf(82297,   87581),
arrayListOf(24071,   53175),
arrayListOf(85766,   82069),
arrayListOf(48467,   36089),
arrayListOf(16301,   77080),
arrayListOf(89176,   48368),
arrayListOf(76512,   29182),
arrayListOf(61987,   37730),
arrayListOf(10252,   83226),
arrayListOf(42503,   12203),
arrayListOf(75498,   71010),
arrayListOf(56685,   98679),
arrayListOf(22338,   48368),
arrayListOf(40666,   86581),
arrayListOf(88276,   32262),
arrayListOf(69493,   94854),
arrayListOf(75435,   22046),
arrayListOf(91561,   48368),
arrayListOf(99202,   42878),
arrayListOf(90978,   38171),
arrayListOf(89712,   77080),
arrayListOf(48877,   36148),
arrayListOf(31528,   92078),
arrayListOf(15135,   36258),
arrayListOf(47468,   10112),
arrayListOf(23557,   10112),
arrayListOf(46381,   98492),
arrayListOf(95007,   57390),
arrayListOf(31053,   95937),
arrayListOf(26099,   27278),
arrayListOf(34939,   75494),
arrayListOf(44252,   59542),
arrayListOf(54945,   73875),
arrayListOf(26328,   38171),
arrayListOf(73116,   46131),
arrayListOf(16168,   13789),
arrayListOf(28518,   28323),
arrayListOf(25310,   28056),
arrayListOf(63436,   27589),
arrayListOf(77562,   37730),
arrayListOf(80614,   82409),
arrayListOf(76421,   63235),
arrayListOf(24521,   53590),
arrayListOf(17937,   86492),
arrayListOf(80687,   56569),
arrayListOf(56076,   10767),
arrayListOf(64810,   74623),
arrayListOf(73278,   26540),
arrayListOf(58083,   46584),
arrayListOf(90208,   32262),
arrayListOf(17793,   65461),
arrayListOf(92155,   47552),
arrayListOf(47982,   91242),
arrayListOf(82069,   77080),
arrayListOf(39226,   87581),
arrayListOf(34622,   42348),
arrayListOf(99735,   46584),
arrayListOf(22264,   37730),
arrayListOf(46131,   70590),
arrayListOf(90426,   18162),
arrayListOf(75148,   63803),
arrayListOf(98835,   70822),
arrayListOf(80373,   30652),
arrayListOf(62705,   46131),
arrayListOf(95974,   32262),
arrayListOf(54882,   36453),
arrayListOf(50578,   71111),
arrayListOf(30132,   39798),
arrayListOf(22527,   35101),
arrayListOf(41027,   91852),
arrayListOf(69013,   46238),
arrayListOf(79152,   69190),
arrayListOf(89330,   61021),
arrayListOf(85358,   13789),
arrayListOf(15086,   54357),
arrayListOf(50002,   39467),
arrayListOf(42579,   42483),
arrayListOf(11717,   87581),
arrayListOf(43825,   24664),
arrayListOf(50771,   87581),
arrayListOf(89105,   45839),
arrayListOf(84561,   92078),
arrayListOf(42692,   38899),
arrayListOf(20001,   94609),
arrayListOf(40205,   38051),
arrayListOf(13295,   20519),
arrayListOf(96020,   10112),
arrayListOf(47293,   87899),
arrayListOf(94929,   10112),
arrayListOf(24422,   82448),
arrayListOf(62066,   59975),
arrayListOf(52303,   86581),
arrayListOf(79329,   72343),
arrayListOf(69417,   16516),
arrayListOf(13062,   47552),
arrayListOf(41201,   84658),
arrayListOf(92635,   62180),
arrayListOf(19834,   91848),
arrayListOf(34343,   18222),
arrayListOf(18208,   30134),
arrayListOf(82611,   63803),
arrayListOf(12207,   74511),
arrayListOf(93804,   53502),
arrayListOf(51066,   33260),
arrayListOf(28374,   66275),
arrayListOf(34107,   10112),
arrayListOf(13223,   80233),
arrayListOf(97959,   94470),
arrayListOf(51054,   57117),
arrayListOf(82951,   30540),
arrayListOf(61626,   32898),
arrayListOf(52816,   16045),
arrayListOf(67095,   46131),
arrayListOf(96825,   70590),
arrayListOf(34307,   77500),
arrayListOf(98853,   35083),
arrayListOf(76437,   65439),
arrayListOf(71489,   77080),
arrayListOf(46520,   16597),
arrayListOf(15288,   54357),
arrayListOf(34660,   63199),
arrayListOf(65053,   65439),
arrayListOf(99414,   57117),
arrayListOf(85660,   83055),
arrayListOf(10245,   32262),
arrayListOf(12775,   67705),
arrayListOf(57298,   65439),
arrayListOf(64105,   36878),
arrayListOf(36104,   12422),
arrayListOf(89241,   56000),
arrayListOf(41045,   87764),
arrayListOf(16506,   88026),
arrayListOf(53044,   44649),
arrayListOf(17425,   84939),
arrayListOf(56000,   69714),
arrayListOf(63575,   92078),
arrayListOf(50418,   19328),
arrayListOf(39915,   10112),
arrayListOf(97542,   66182),
arrayListOf(97468,   16506),
arrayListOf(74779,   94609),
arrayListOf(90120,   17677),
arrayListOf(91404,   87581),
arrayListOf(83440,   31253),
arrayListOf(80583,   16585),
arrayListOf(16542,   82069),
arrayListOf(34305,   48368),
arrayListOf(95455,   30383),
arrayListOf(56639,   87581),
arrayListOf(33983,   12422),
arrayListOf(36565,   47552),
arrayListOf(63737,   32262),
arrayListOf(60378,   37730),
arrayListOf(80067,   95189),
arrayListOf(45068,   61725),
arrayListOf(20720,   74180),
arrayListOf(24918,   94609),
arrayListOf(18264,   86581),
arrayListOf(43293,   57117),
arrayListOf(67279,   38551),
arrayListOf(75286,   95937),
arrayListOf(19582,   71378),
arrayListOf(62806,   12497),
arrayListOf(48345,   96497),
arrayListOf(45026,   68499),
arrayListOf(97371,   36028),
arrayListOf(80754,   74761),
arrayListOf(97543,   54357),
arrayListOf(51110,   12422),
arrayListOf(23427,   24635),
arrayListOf(44698,   68582),
arrayListOf(84624,   28102),
arrayListOf(74813,   12960),
arrayListOf(94691,   82069),
    arrayListOf(68498,   93943),
    arrayListOf(30492,   52810),
    arrayListOf(65243,   34777),
    arrayListOf(12244,   82069),
    arrayListOf(14525,   65439),
    arrayListOf(75430,   98694),
    arrayListOf(73494,   87567),
    arrayListOf(97587,   67336),
    arrayListOf(59739,   59542),
    arrayListOf(38047,   30492),
    arrayListOf(35519,   43518),
    arrayListOf(64167,   92078),
    arrayListOf(52460,   72101),
    arrayListOf(49707,   81573),
    arrayListOf(86581,   24885),
    arrayListOf(93340,   69244),
    arrayListOf(91249,   13789),
    arrayListOf(35632,   52637),
    arrayListOf(78007,   56318),
    arrayListOf(86640,   46131),
    arrayListOf(84853,   30492),
    arrayListOf(69589,   55403),
    arrayListOf(87840,   94609),
    arrayListOf(15931,   65439),
    arrayListOf(87788,   94609),
    arrayListOf(36704,   39467),
    arrayListOf(56849,   92199),
    arrayListOf(23845,   70822),
    arrayListOf(58771,   59306),
    arrayListOf(15094,   72864),
    arrayListOf(78669,   38116),
    arrayListOf(67290,   30492),
    arrayListOf(30809,   12422),
    arrayListOf(60616,   82069),
    arrayListOf(99946,   86597),
    arrayListOf(57245,   10112),
    arrayListOf(14346,   59022),
    arrayListOf(95083,   79436),
    arrayListOf(57974,   65334),
    arrayListOf(22448,   86581),
    arrayListOf(89557,   42455),
    arrayListOf(72735,   70224),
    arrayListOf(80323,   28694),
    arrayListOf(19558,   59542),
    arrayListOf(66100,   67968),
    arrayListOf(29557,   54357),
    arrayListOf(75549,   48368),
    arrayListOf(47979,   65120),
    arrayListOf(81370,   26550),
    arrayListOf(99542,   80446),
    arrayListOf(92151,   48368),
    arrayListOf(60693,   60658),
    arrayListOf(70590,   36856),
    arrayListOf(93811,   95439),
    arrayListOf(50263,   78334),
    arrayListOf(51728,   74556),
    arrayListOf(48629,   23585),
    arrayListOf(63500,   35242),
    arrayListOf(98688,   74623),
    arrayListOf(50638,   39467),
    arrayListOf(39320,   57117),
    arrayListOf(85601,   48368),
    arrayListOf(86749,   63803),
    arrayListOf(84452,   24596),
    arrayListOf(40346,   33260),
    arrayListOf(56693,   59543),
    arrayListOf(96450,   10429),
    arrayListOf(46319,   50421),
    arrayListOf(88183,   63450),
    arrayListOf(47057,   56000),
    arrayListOf(99066,   65734),
    arrayListOf(95736,   95937),
    arrayListOf(49970,   77187),
    arrayListOf(76310,   86581),
    arrayListOf(72960,   21713),
    arrayListOf(61234,   33798),
    arrayListOf(20364,   70590),
    arrayListOf(89304,   82069),
    arrayListOf(90141,   11734),
    arrayListOf(11708,   88748),
    arrayListOf(67064,   10112),
    arrayListOf(51923,   71970),
    arrayListOf(47055,   36089),
    arrayListOf(45990,   28498),
    arrayListOf(89727,   87581),
    arrayListOf(92801,   71911),
    arrayListOf(39807,   46584),
    arrayListOf(72390,   35136),
    arrayListOf(16446,   62868),
    arrayListOf(77863,   56000),
    arrayListOf(42686,   13789),
    arrayListOf(28678,   75289),
    arrayListOf(84858,   67442),
    arrayListOf(64404,   84225),
    arrayListOf(77138,   70822),
    arrayListOf(48368,   33260),
    arrayListOf(89589,   10112),
    arrayListOf(92469,   43286),
    arrayListOf(66906,   19599),
    arrayListOf(96794,   74623),
    arrayListOf(98997,   15262),
    arrayListOf(32791,   74556),
    arrayListOf(86217,   36089),
    arrayListOf(23368,   31640),
    arrayListOf(88661,   19276),
    arrayListOf(72933,   85540),
    arrayListOf(22703,   30492),
    arrayListOf(71905,   65439),
    arrayListOf(58050,   40461),
    arrayListOf(29588,   95734),
    arrayListOf(39243,   55933),
    arrayListOf(83527,   17481),
    arrayListOf(15249,   58026),
    arrayListOf(77033,   47662),
    arrayListOf(47552,   86581),
    arrayListOf(57262,   69752),
    arrayListOf(20061,   18772),
    arrayListOf(81279,   43751),
    arrayListOf(58632,   70157),
    arrayListOf(13683,   94609),
    arrayListOf(21964,   74556),
    arrayListOf(95224,   59604),
    arrayListOf(83465,   88283),
    arrayListOf(81225,   36089),
    arrayListOf(16585,   17481),
    arrayListOf(15766,   15653),
    arrayListOf(50261,   57292),
    arrayListOf(82233,   54937),
    arrayListOf(60140,   94609),
    arrayListOf(52750,   31767),
    arrayListOf(20808,   56000),
    arrayListOf(57243,   92469),
    arrayListOf(43252,   32262),
    arrayListOf(60198,   86581),
    arrayListOf(18620,   55678),
    arrayListOf(44051,   50219),
    arrayListOf(15210,   39162),
    arrayListOf(60005,   36089),
    arrayListOf(66217,   74556),
    arrayListOf(13853,   70822),
    arrayListOf(63803,   70822),
    arrayListOf(35040,   65079),
    arrayListOf(65842,   38038),
    arrayListOf(39316,   20720),
    arrayListOf(87663,   65984),
    arrayListOf(20060,   68582),
    arrayListOf(25890,   48796),
    arrayListOf(16116,   82639),
    arrayListOf(31571,   70822),
    arrayListOf(43980,   84152),
    arrayListOf(53704,   11951),
    arrayListOf(79055,   42179),
    arrayListOf(57231,   22127),
    arrayListOf(88376,   85408),
    arrayListOf(59541,   95959),
    arrayListOf(92556,   53432),
    arrayListOf(88194,   16317),
    arrayListOf(34727,   30904),
    arrayListOf(16387,   57117),
    arrayListOf(96730,   10644),
    arrayListOf(65083,   36089),
    arrayListOf(15228,   16506),
    arrayListOf(81423,   59542),
    arrayListOf(87899,   17481),
    arrayListOf(90911,   85798),
    arrayListOf(17159,   83599),
    arrayListOf(50392,   77080),
    arrayListOf(22864,   43286),
    arrayListOf(37528,   94609),
    arrayListOf(21429,   59542),
    arrayListOf(28265,   46877),
    arrayListOf(46764,   37608),
    arrayListOf(91323,   65439),
    arrayListOf(83391,   35269),
    arrayListOf(74503,   39369),
    arrayListOf(93683,   63803),
    arrayListOf(31047,   38528),
    arrayListOf(53705,   33260),
    arrayListOf(74884,   86581),
    arrayListOf(54241,   99733),
    arrayListOf(45641,   73338),
    arrayListOf(64783,   94609),
    arrayListOf(36885,   76835),
    arrayListOf(94878,   70590),
    arrayListOf(95560,   21274),
    arrayListOf(61985,   67119),
    arrayListOf(65075,   74623),
    arrayListOf(32813,   86204),
    arrayListOf(36749,   72304),
    arrayListOf(78654,   50542),
    arrayListOf(86690,   74556),
    arrayListOf(70019,   32262),
    arrayListOf(20641,   60329),
    arrayListOf(77752,   57117),
    arrayListOf(60383,   20123),
    arrayListOf(90352,   74623),
    arrayListOf(24141,   71761),
    arrayListOf(65390,   10350),
    arrayListOf(47054,   38708),
    arrayListOf(39003,   57915),
    arrayListOf(38161,   92078),
    arrayListOf(38171,   32262),
    arrayListOf(84400,   10112),
    arrayListOf(15341,   70822),
    arrayListOf(39428,   16506),
    arrayListOf(13942,   13789),
    arrayListOf(96936,   70483),
    arrayListOf(93060,   50175),
    arrayListOf(38192,   67104),
    arrayListOf(46944,   64882),
    arrayListOf(10846,   12422),
    arrayListOf(35101,   35801),
    arrayListOf(91104,   20720),
    arrayListOf(13040,   13789),
    arrayListOf(32161,   31456),
    arrayListOf(97253,   86581),
    arrayListOf(70362,   70590),
    arrayListOf(53579,   26550),
    arrayListOf(32295,   56680),
    arrayListOf(77624,   74556),
    arrayListOf(19453,   38171),
    arrayListOf(11458,   82069),
    arrayListOf(39312,   94596),
    arrayListOf(68109,   81118),
    arrayListOf(63009,   59542),
    arrayListOf(96761,   33260),
    arrayListOf(42532,   96201),
    arrayListOf(42166,   87800),
    arrayListOf(87613,   44967),
    arrayListOf(69532,   34024),
    arrayListOf(48387,   83207),
    arrayListOf(54987,   28919),
    arrayListOf(20342,   84225),
    arrayListOf(23664,   56000),
    arrayListOf(46174,   10112),
    arrayListOf(72309,   12474),
    arrayListOf(72157,   73250),
    arrayListOf(28932,   14632),
    arrayListOf(36882,   84225),
    arrayListOf(23261,   38171),
    arrayListOf(99849,   41962),
    arrayListOf(95036,   44159),
    arrayListOf(67696,   12422),
    arrayListOf(58158,   12422),
    arrayListOf(99688,   84696),
    arrayListOf(95937,   56267),
    arrayListOf(67472,   28880),
    arrayListOf(32262,   78595),
    arrayListOf(39793,   31505),
    arrayListOf(53311,   87581),
    arrayListOf(28411,   51506),
    arrayListOf(53156,   88986),
    arrayListOf(97772,   95152),
    arrayListOf(27795,   70590),
    arrayListOf(25013,   30223),
    arrayListOf(14528,   72611),
    arrayListOf(76358,   11601),
    arrayListOf(46584,   32226),
    arrayListOf(45091,   53888),
    arrayListOf(78740,   82069),
    arrayListOf(28185,   56000),
    arrayListOf(86150,   33260),
    arrayListOf(12422,   13789),
    arrayListOf(49946,   36089),
    arrayListOf(39558,   91418),
    arrayListOf(12969,   78072),
    arrayListOf(30758,   23674),
    arrayListOf(30625,   72335),
    arrayListOf(29062,   46065),
    arrayListOf(51088,   61952),
    arrayListOf(88725,   61869),
    arrayListOf(94002,   74556),
    arrayListOf(35800,   29768),
    arrayListOf(43599,   95937),
    arrayListOf(65922,   82638),
    arrayListOf(52159,   91936),
    arrayListOf(96552,   48368),
    arrayListOf(29575,   38995),
    arrayListOf(51418,   82069),
    arrayListOf(39467,   36420),
    arrayListOf(76259,   15058),
    arrayListOf(52506,   24873),
    arrayListOf(34793,   68305),
    arrayListOf(36089,   94116),
    arrayListOf(25337,   69496),
    arrayListOf(46924,   86581),
    arrayListOf(62992,   82069),
    arrayListOf(62236,   95937),
    arrayListOf(50926,   25384),
    arrayListOf(72595,   74556),
    arrayListOf(53666,   67031),
    arrayListOf(44374,   15724),
    arrayListOf(44629,   51188),
    arrayListOf(80493,   95937),
    arrayListOf(76680,   59202),
    arrayListOf(96833,   95937),
    arrayListOf(96740,   86581),
    arrayListOf(90400,   65439),
    arrayListOf(41922,   10112),
    arrayListOf(10333,   23762),
    arrayListOf(13789,   94609),
    arrayListOf(79941,   85091),
    arrayListOf(34855,   55865),
    arrayListOf(87532,   37140),
    arrayListOf(85678,   46584),
    arrayListOf(34735,   74556),
    arrayListOf(27059,   28517),
    arrayListOf(62170,   92078),
    arrayListOf(59542,   84972),
    arrayListOf(44107,   46131),
    arrayListOf(62531,   86581),
    arrayListOf(36662,   56000),
    arrayListOf(36292,   59542),
    arrayListOf(76115,   57037),
    arrayListOf(39296,   41740),
    arrayListOf(34919,   10743),
    arrayListOf(74948,   86439),
    arrayListOf(50539,   59294),
    arrayListOf(85056,   31471),
    arrayListOf(28116,   65439),
    arrayListOf(39085,   38176),
    arrayListOf(84409,   95937),
    arrayListOf(57138,   46131),
    arrayListOf(72483,   57117),
    arrayListOf(32395,   72441),
    arrayListOf(95005,   74883),
    arrayListOf(87581,   51660),
    arrayListOf(28602,   28664),
    arrayListOf(34996,   46131),
    arrayListOf(96430,   56339),
    arrayListOf(77226,   70822),
    arrayListOf(93760,   10112),
    arrayListOf(40364,   94609),
    arrayListOf(40141,   39467),
    arrayListOf(68490,   40042),
    arrayListOf(48192,   93216),
    arrayListOf(68068,   70590),
    arrayListOf(73633,   15355),
    arrayListOf(83619,   47552),
    arrayListOf(81572,   73873),
    arrayListOf(25924,   70822),
    arrayListOf(29554,   63803),
    arrayListOf(19515,   26687),
    arrayListOf(61203,   65439),
    arrayListOf(66108,   77080),
    arrayListOf(34039,   33260),
    arrayListOf(54877,   35542),
    arrayListOf(38583,   96489),
    arrayListOf(90667,   42450),
    arrayListOf(84938,   10487),
    arrayListOf(46965,   59542),
    arrayListOf(54823,   74069),
    arrayListOf(71321,   73685),
    arrayListOf(19154,   57117),
    arrayListOf(73217,   30492),
    arrayListOf(76105,   13647),
    arrayListOf(39670,   12422),
    arrayListOf(30004,   64951),
    arrayListOf(21400,   16931),
    arrayListOf(58732,   46131),
    arrayListOf(46185,   57117),
    arrayListOf(35140,   97447),
    arrayListOf(21937,   32262),
    arrayListOf(29766,   37730),
    arrayListOf(97110,   17481),
    arrayListOf(37622,   70822),
    arrayListOf(10481,   46131),
    arrayListOf(89082,   37730),
    arrayListOf(37941,   74556),
    arrayListOf(14004,   13789),
    arrayListOf(75256,   31754),
    arrayListOf(91586,   98835),
    arrayListOf(70127,   84728),
    arrayListOf(27519,   76800),
    arrayListOf(30742,   29667),
    arrayListOf(40956,   72181),
    arrayListOf(38337,   85286),
    arrayListOf(93338,   32262),
    arrayListOf(17167,   48368),
    arrayListOf(90586,   87581),
    arrayListOf(77695,   72650),
    arrayListOf(78449,   10112),
    arrayListOf(14007,   92469),
    arrayListOf(44816,   56000),
    arrayListOf(92128,   12422),
    arrayListOf(70434,   89508),
    arrayListOf(46495,   17481),
    arrayListOf(86412,   57117),
    arrayListOf(12915,   29947),
    arrayListOf(31239,   98835),
    arrayListOf(25873,   62842),
    arrayListOf(18560,   54357),
    arrayListOf(56101,   27741),
    arrayListOf(85775,   70590),
    arrayListOf(36475,   51980),
    arrayListOf(80038,   10112),
    arrayListOf(98826,   30492),
    arrayListOf(41315,   82816),
    arrayListOf(11389,   82624),
    arrayListOf(11947,   75881),
    arrayListOf(26407,   10112),
    arrayListOf(30869,   41026),
    arrayListOf(87026,   44676),
    arrayListOf(41060,   77177),
    arrayListOf(27239,   32212),
    arrayListOf(50309,   47552),
    arrayListOf(28120,   35101),
    arrayListOf(52772,   87899),
    arrayListOf(50851,   13789),
    arrayListOf(52738,   67642),
    arrayListOf(73374,   61276),
    arrayListOf(29063,   83110),
    arrayListOf(75283,   77080),
    arrayListOf(91345,   33260),
    arrayListOf(14809,   19229),
    arrayListOf(82519,   27777),
    arrayListOf(92688,   65439),
    arrayListOf(10526,   48368),
    arrayListOf(59702,   92469),
    arrayListOf(35688,   48965),
    arrayListOf(87590,   24828),
    arrayListOf(40206,   75331),
    arrayListOf(36194,   74556),
    arrayListOf(43336,   12746),
    arrayListOf(26034,   29117),
    arrayListOf(23466,   47552),
    arrayListOf(33234,   19772),
    arrayListOf(17481,   11383),
    arrayListOf(68582,   54357),
    arrayListOf(36038,   20809),
    arrayListOf(33704,   98835),
    arrayListOf(87642,   46131),
    arrayListOf(37947,   38171),
    arrayListOf(17577,   54357),
    arrayListOf(13994,   48368),
    arrayListOf(70913,   45734),
    arrayListOf(11985,   23504),
    arrayListOf(82269,   84225),
    arrayListOf(83126,   70590),
    arrayListOf(47981,   50609),
    arrayListOf(71785,   10112),
    arrayListOf(38305,   87857),
    arrayListOf(59774,   78056),
    arrayListOf(62970,   82069),
    arrayListOf(21547,   84225),
    arrayListOf(63443,   87640),
    arrayListOf(74676,   92894),
    arrayListOf(54357,   35752),
    arrayListOf(88456,   38171),
    arrayListOf(80643,   40334),
    arrayListOf(78727,   73557),
    arrayListOf(86551,   13789),
    arrayListOf(31360,   70822),
    arrayListOf(38144,   12422),
    arrayListOf(39925,   26550),
    arrayListOf(18733,   67964),
    arrayListOf(14557,   23598),
    arrayListOf(68231,   70590),
    arrayListOf(28923,   37251),
    arrayListOf(36731,   36089),
    arrayListOf(16989,   57160),
    arrayListOf(10112,   90976),
    arrayListOf(81269,   32323),
    arrayListOf(46176,   11467),
    arrayListOf(34165,   74556),
    arrayListOf(30496,   32262),
    arrayListOf(33260,   70590),
    arrayListOf(91319,   45070),
    arrayListOf(80484,   38171),
    arrayListOf(61567,   48368),
    arrayListOf(36103,   70590),
    arrayListOf(45693,   70590),
    arrayListOf(41025,   43757),
    arrayListOf(36802,   65596),
    arrayListOf(21523,   98958),
    arrayListOf(80599,   32262),
    arrayListOf(49397,   92078),
    arrayListOf(74366,   65439),
    arrayListOf(30292,   94948),
    arrayListOf(20673,   10112),
    arrayListOf(13158,   46131),
    arrayListOf(89970,   26550),
    arrayListOf(70825,   12276),
    arrayListOf(96736,   32750),
    arrayListOf(26698,   17481),
    arrayListOf(94201,   26049),
    arrayListOf(66228,   18185),
    arrayListOf(50623,   91018),
    arrayListOf(63509,   70822),
    arrayListOf(96572,   46131),
    arrayListOf(34380,   46715),
    arrayListOf(21120,   17481),
    arrayListOf(24159,   56000),
    arrayListOf(59659,   74556),
    arrayListOf(31572,   53951),
    arrayListOf(48375,   82069),
    arrayListOf(12985,   36089),
    arrayListOf(82040,   10557),
    arrayListOf(63252,   57117),
    arrayListOf(31520,   86581),
    arrayListOf(38262,   13789),
    arrayListOf(41980,   40901),
    arrayListOf(76273,   47552),
    arrayListOf(11812,   46131),
    arrayListOf(28759,   77080),
    arrayListOf(12882,   92653),
    arrayListOf(64935,   33260),
    arrayListOf(26550,   83813),
    arrayListOf(19156,   58394),
    arrayListOf(93914,   35101),
    arrayListOf(43129,   96976),
    arrayListOf(13090,   57117),
    arrayListOf(98463,   76524),
    arrayListOf(36993,   46131),
    arrayListOf(89249,   35207),
    arrayListOf(12936,   18458),
    arrayListOf(26497,   56000),
    arrayListOf(75288,   35237),
    arrayListOf(79742,   82354),
    arrayListOf(65715,   12422),
    arrayListOf(21544,   29737),

)

data class Item (
    val number: Int = 0,
    var processed: Boolean = false
)