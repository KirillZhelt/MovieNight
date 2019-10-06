package dev.kirillzhelt.androidacademyapp.model

class Repository {

    private val movies = listOf(
        Movie("https://image.tmdb.org/t/p/w342/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg",
            "https://image.tmdb.org/t/p/original/t5KONotASgVKq4N19RyhIthWOPG.jpg",
            "Jurassic World",
            "Twenty-two years after the original Jurassic Park failed, the new park, also known as Jurassic World, is open for business. After years of studying genetics, the scientists on the park genetically engineer a new breed of dinosaur, the Indominus Rex. When everything goes horribly wrong, will our heroes make it off the island?",
            "https://www.youtube.com/watch?v=RFinNxS5KN4",
            "June 9, 2015"
            ),
        Movie("https://image.tmdb.org/t/p/w342/eyWICPcxOuTcDDDbTMOZawoOn8d.jpg",
            "https://image.tmdb.org/t/p/original/2uSCHUsmzb6KkQPFSxBQ7bgfJLE.jpg",
            "The Meg",
            "Rescue diver Jonas Taylor is attempting to save the crew of a damaged nuclear submarine when he sees the hull of the sub being rammed by a giant creature. Two of his crew are trapped in the damaged sub; Taylor is forced to flee, realizing that attempting rescue would result in the death of everyone on the deep-submergence rescue vehicle. Moments later, the nuclear sub explodes. Taylor's account of the story is dismissed by fellow survivor Dr. Heller, who believes that Taylor turned coward due to pressure-induced psychosis.",
            "https://www.youtube.com/watch?v=udm5jUA-2bs",
            "July 30, 2018"
            ),
        Movie("https://image.tmdb.org/t/p/w342/2slvblTroiT1lY9bYLK7Amigo1k.jpg",
            "https://image.tmdb.org/t/p/original/r4clWIxKeWoqrHspQP0XunuUmB7.jpg",
            "The First Purge",
            "America's third political party, the New Founding Fathers of America, comes to power and conducts an experiment: no laws for 12 hours on Staten Island. No one has to stay on the island, but \$5,000 is given to anyone who does.",
            "https://www.youtube.com/watch?v=UL29y0ah92w",
            "July 4, 2018"
            ),
        Movie("https://image.tmdb.org/t/p/w342/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg",
            "https://image.tmdb.org/t/p/original/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg",
            "Deadpool 2",
            "Foul-mouthed mutant mercenary Wade Wilson (AKA. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg, Cable.",
            "https://www.youtube.com/watch?v=D86RtevtfrA",
            "May 10, 2018"
            ),
        Movie("https://image.tmdb.org/t/p/w342/uxzzxijgPIY7slzFvMotPv8wjKA.jpg",
            "https://image.tmdb.org/t/p/original/6ELJEzQJ3Y45HczvreC3dg0GV5R.jpg",
            "Black Panther",
            "After the events of Captain America: Civil War, Prince T'Challa returns home to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new king. However, T'Challa soon finds that he is challenged for the throne from factions within his own country. When two foes conspire to destroy Wakanda, the hero known as Black Panther must team up with C.I.A. agent Everett K. Ross and members of the Dora Milaje, Wakandan special forces, to prevent Wakanda from being dragged into a world war.",
            "https://www.youtube.com/watch?v=xjDjIWPwcPU",
            "January 29, 2018"
            ),
        Movie("https://image.tmdb.org/t/p/w342/MvYpKlpFukTivnlBhizGbkAe3v.jpg",
            "https://image.tmdb.org/t/p/original/6vea77yJv3jMEUzh1crnuFitKDz.jpg",
            "Ocean's Eight",
            "Debbie Ocean gathers an all-female crew to attempt an impossible heist at New York City's yearly Met Gala.",
            "https://www.youtube.com/watch?v=MFWF9dU5Zc0",
            "June 5, 2018"
            ),
        Movie("https://image.tmdb.org/t/p/w342/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
            "https://image.tmdb.org/t/p/original/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg",
            "Interstellar",
            "Earth's future has been riddled by disasters, famines, and droughts. There is only one way to ensure mankind's survival: Interstellar travel. A newly discovered wormhole in the far reaches of our solar system allows a team of astronauts to go where no man has gone before, a planet that may have the right environment to sustain human life.",
            "https://www.youtube.com/watch?v=3WzHXI5HizQ",
            "October 26, 2014"
            ),
        Movie("https://image.tmdb.org/t/p/w342/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg",
            "https://image.tmdb.org/t/p/original/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg",
            "Thor - Ragnarok",
            "Thor (Chris Hemsworth) is imprisoned on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarök, the destruction of his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela (Cate Blanchett).",
            "https://www.youtube.com/watch?v=ue80QwXMRHg",
            "October 10, 2017"
            ),
        Movie("https://image.tmdb.org/t/p/w342/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg",
            "https://image.tmdb.org/t/p/original/kHex2XdOmGtazk1VfJjp4bl7BIc.jpg",
            "Guardians Of The Galaxy",
            "The Guardians struggle to keep together as a team while dealing with their personal family issues, notably Star-Lord's encounter with his father the ambitious celestial being Ego.",
            "https://www.youtube.com/watch?v=PsO6ZnUZI0g",
            "August 1, 2014"
            )
        )

    fun loadMovies() = movies
}