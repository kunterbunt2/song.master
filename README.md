# song.master
a very special project in a sense that it will not be of any interet to anybody than me.
# what does it do?
song.master is a java application that scans a folder for songs in mp3 format composed by me and 
1. compares the found songs to a list of songs within the application to ensure that they match
2. checks if the mp3 album cover art is up to date (cover art must exist)
3. checks if the mp3 metadate is up to date (compared to the data within the application)
4. generates a -wave.png file visualizing the wave form of the song
5. generates a mp4 video using the album cover art and the mp3 metadata
6. generates png files of time-lines for every album with links to the songs web page
# dependencies
song.master expects to find
1. a folder located at C:/data/abdalla.bushnaq.de/sites/fileadmin/audio
    1. inside this folder it is expecting folders with the names of song albums
    2. inside each album folder it expects to find for every song in its list
        1. an mp3 file
        2. a png file with the song cover art
2. a folder located at C:/data/abdalla.bushnaq.de/sites/fileadmin/images used to store the generated png map files
3. a folder located at C:/data/abdalla.bushnaq.de/sites/fileadmin/html used to store the html map files


