package vcmsa.projects.icetask1

class Commands {
    init {
        commmandData.add(
            ColourRows(
                "Click the colour red",
                "Click the colour yellow",
                "Click the colour green",
                "Click the colour blue"
            )
        )
        commmandData.add(
            ColourRows(
                "Click the red colour",
                "Click the yellow colour",
                "Click the green colour",
                "Click the blue colour"
            )
        )
        commmandData.add(ColourRows("Click red", "Click yellow", "Click green", "Click blue"))
        commmandData.add(
            ColourRows(
                "Don't click Yellow, Green or Blue",
                "Don't click Red, Blue or Green",
                "Don't click Yellow, Red or Blue",
                "Don't click Green, Yellow or Blue"
            )
        )
        commmandData.add(
            ColourRows(
                "Click the first colour of the rainbow",
                "Click the main colour of Spongebob",
                "Click the colour of grass",
                "Click the colour of the ocean"
            )
        )
        commmandData.add(
            ColourRows(
                "Click the colour that rhymes with 'bed'",
                "Click the colour that rhymes with 'mellow'",
                "Click the colour that sounds like 'mean'",
                "Click the colour that rhymes with 'flu'"
            )
        )
    }
}
