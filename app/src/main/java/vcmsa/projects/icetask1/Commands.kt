package vcmsa.projects.icetask1

data class Commands (
    val RedCommand: String= "Click red",
    val YellowCommand: String = "Click yellow",
    val GreenCommand: String= "Click green",
    val BlueCommand: String = "Click blue",

    val RedCommand2: String  ="Don't click Yellow, Green or Blue.",
    val YellowCommand2: String  ="Don't click Red, Blue or Green.",
    val GreenCommand2: String  ="Don't click Yellow, Red or Blue.",
    val BlueCommand2: String  ="Don't click Green, Yellow or Blue.",

    val RedCommand3: String  ="Click the first colour of the rainbow",
    val YellowCommand3: String  ="Click the main colour of Spongebob.",
    val GreenCommand3: String  ="Click the colour of grass.",
    val BlueCommand3: String  ="Click the colour of the ocean.",

    val RedCommand4: String  ="Click the colour that rhymes with 'bed'.",
    val YellowCommand4: String  ="Click the colour that rhymes with 'mellow'.",
    val GreenCommand4: String  ="Click the colour that sounds like 'mean'.",
    val BlueCommand4: String  ="Click the colour that rhymes with 'flu.' ",
)
