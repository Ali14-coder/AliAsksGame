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
        commmandData.add(ColourRows(
            "Don't click yellow, green, or blue",         // Red
            "Avoid red, green, and blue",                  // Yellow
            "Not red, yellow, or blue",                    // Green
            "Skip red, yellow, and green"                   // Blue
        ))
        commmandData.add(ColourRows(
            "Click the colour that means stop",            // Red
            "Click the colour that shines like the sun",   // Yellow
            "Click the colour where frogs live",            // Green
            "Click the colour of the deepest ocean"         // Blue
        ))
        commmandData.add(ColourRows(
            "The colour of passion and fire",               // Red
            "The colour of happiness and bees",             // Yellow
            "The colour of nature and envy",                 // Green
            "The colour of calm skies and blueberries"      // Blue
        ))
        commmandData.add(ColourRows(
            "Don’t pick the colour of sunshine, grass, or sky",   // Red
            "Don’t pick the colour of fire, grass, or sky",       // Yellow
            "Don’t pick the colour of fire, sunshine, or sky",    // Green
            "Don’t pick the colour of fire, sunshine, or grass"   // Blue
        ))
        commmandData.add(ColourRows(
            "The colour that rhymes with 'bed' but isn't blue",   // Red
            "The colour that rhymes with 'fellow' but isn't red", // Yellow
            "The colour that sounds like 'clean' but isn't red",  // Green
            "The colour that rhymes with 'true' but isn't red"    // Blue
        ))
        commmandData.add(ColourRows(
            "I’m the colour of a strawberry, but not of the sun", // Red
            "I’m the colour of a lemon, but not the ocean",       // Yellow
            "I’m the colour of grass, but not a blueberry",       // Green
            "I’m the colour of the sky, but not a lemon"          // Blue
        ))
        commmandData.add(ColourRows(
            "Avoid colours of grass, sun, and sky",                // Red
            "Avoid colours of fire, grass, and sky",               // Yellow
            "Avoid colours of fire, sun, and sky",                 // Green
            "Avoid colours of fire, sun, and grass"                // Blue
        ))
        commmandData.add(ColourRows(
            "I'm the colour of heat and danger, not cold and calm",  // Red
            "I'm bright like daylight, but not the sky or grass",    // Yellow
            "I'm fresh like spring leaves, not fire or sun",         // Green
            "I'm deep like the ocean, not the sun or grass"          // Blue
        ))
        commmandData.add(ColourRows(
            "Not the colour of lemons, frogs, or water",             // Red
            "Not the colour of fire, frogs, or water",               // Yellow
            "Not the colour of fire, lemons, or water",              // Green
            "Not the colour of fire, lemons, or frogs"               // Blue
        ))
        commmandData.add(ColourRows(
            "I’m redder than a ripe tomato but not yellow",          // Red
            "I’m yellower than sunshine but not green",               // Yellow
            "I’m greener than a shamrock but not blue",               // Green
            "I’m bluer than the ocean but not red"                    // Blue
        ))
        commmandData.add(ColourRows(
            "Choose me if you want the colour of anger, not calm",   // Red
            "Choose me if you want the colour of gold, not grass",    // Yellow
            "Choose me if you want the colour of envy, not the sea",  // Green
            "Choose me if you want the colour of sadness, not fire"   // Blue
        ))
        commmandData.add(ColourRows(
            "Not green, blue or yellow; think hot and bold",          // Red
            "Not red, green or blue; think bright and warm",          // Yellow
            "Not red, yellow or blue; think fresh and cool",          // Green
            "Not red, yellow or green; think deep and calm"           // Blue
        ))
        commmandData.add(ColourRows(
            "Colour of blood but not grass or sky",                   // Red
            "Colour of butter but not fire or water",                 // Yellow
            "Colour of leaves but not sun or sea",                     // Green
            "Colour of the ocean but not sun or grass"                 // Blue
        ))
        commmandData.add(ColourRows(
            "Think of roses, but not lemons or grass",                 // Red
            "Think of sunflowers, but not roses or frogs",             // Yellow
            "Think of forests, but not roses or oceans",               // Green
            "Think of lakes, but not roses or lemons"                  // Blue
        ))
        commmandData.add(ColourRows(
            "I’m warm, fiery, and bold, but not bright or cool",       // Red
            "I’m bright, sunny, and cheerful, but not warm or cool",   // Yellow
            "I’m fresh, natural, and cool, but not warm or bright",    // Green
            "I’m calm, cool, and deep, but not warm or bright"         // Blue
        ))
        commmandData.add(ColourRows(
            "I’m not yellow, blue, or green; I’m the colour of fire",  // Red
            "I’m not red, blue, or green; I’m the colour of sunshine", // Yellow
            "I’m not red, yellow, or blue; I’m the colour of leaves",  // Green
            "I’m not red, yellow, or green; I’m the colour of the sea" // Blue
        ))
        commmandData.add(ColourRows(
            "Not blue, not green, not yellow, but very hot",           // Red
            "Not red, not green, not blue, but very bright",           // Yellow
            "Not red, not yellow, not blue, but very fresh",           // Green
            "Not red, not yellow, not green, but very cool"            // Blue
        ))
        commmandData.add(ColourRows(
            "I’m redder than anger but not greener than envy",         // Red
            "I’m yellower than gold but not bluer than the ocean",     // Yellow
            "I’m greener than spring but not redder than fire",        // Green
            "I’m bluer than sadness but not yellower than gold"        // Blue
        ))
        commmandData.add(ColourRows(
            "I’m the heat of summer, not the cool of winter",          // Red
            "I’m the brightness of noon, not the darkness of night",   // Yellow
            "I’m the growth of spring, not the decay of autumn",       // Green
            "I’m the depth of the sea, not the height of the mountain" // Blue
        ))
        commmandData.add(ColourRows(
            "I’m red, but not the colour of envy or sadness",          // Red
            "I’m yellow, but not the colour of fire or sadness",       // Yellow
            "I’m green, but not the colour of fire or sadness",        // Green
            "I’m blue, but not the colour of fire or envy"             // Blue
        ))
    }
}
