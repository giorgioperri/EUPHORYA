import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 
import processing.video.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class EUPHORYA extends PApplet {

/*
-/////////////////////////////////////////////         -///////////////:                        `////////////////`         `://///////////////////////////////:-.`                      -///////////////.                         :///////////////`                             `-/+syhddmmmmmddhhyo+:.`                            `/////////////////////////////////::-.`               ://///////////////.                         ./////////////////:              -////////////////////
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`        oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMmhs/.                 yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:                        `:ohmMMMMMMMMMMMMMMMMMMMMMMMNdy+-`                       -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMmho:`          -dMMMMMMMMMMMMMMMMm.                       :NMMMMMMMMMMMMMMMMh.             .mMMMMMMMMMMMMMMMMMMMMo
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`        oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMds-              yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:                     -odNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMmy/`                    -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMd+.        `yMMMMMMMMMMMMMMMMm:                     +MMMMMMMMMMMMMMMMMs`              hMMMMMMMMMMMMMMMMMMMMMN/
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`        oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMd:            yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:                  .+mMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNy:`                 -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNy-        +NMMMMMMMMMMMMMMMN+                   sMMMMMMMMMMMMMMMMN/               oMMMMMMMMMMMMMMMMMMMMMMMN.
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`        oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMh.          yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:                -yNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMm+`               -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNs`       :mMMMMMMMMMMMMMMMMs                `yMMMMMMMMMMMMMMMMd-               /NMMMMMMMMMMMMMMMMMMMMMMMMh`
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`        oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMm:         yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:              .yMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMm/`             -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMd.       .hMMMMMMMMMMMMMMMMh`             .dMMMMMMMMMMMMMMMMy`               .NMMMMMMMMMMMMMMMMMMMMMMMMMMs
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`        oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN:        yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:            `+NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMh.            -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMd.       `oMMMMMMMMMMMMMMMMd.           -mMMMMMMMMMMMMMMMNo                `hMMMMMMMMMMMMMMMMMMMMMMMMMMMM/
sMMMMMMMMMMMMMMMy:::::::::::::::::::::::::::::         oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMN+:::::::::::::/+ymMMMMMMMMMMMMMMMMMd`       yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:           `hMMMMMMMMMMMMMMMMMMMMmyo/:.....-:+sdNMMMMMMMMMMMMMMMMMMMN/           -NMMMMMMMMMMMMMMm/::::::::::::/+ohMMMMMMMMMMMMMMMMMMh         /NMMMMMMMMMMMMMMMm:         /NMMMMMMMMMMMMMMMN:                 sMMMMMMMMMMMMMMNNMMMMMMMMMMMMMm-
sMMMMMMMMMMMMMMM+                                      oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMN-                 /dMMMMMMMMMMMMMMMM+       yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:          .dMMMMMMMMMMMMMMMMMMd+.                :sNMMMMMMMMMMMMMMMMMN+          -NMMMMMMMMMMMMMMd.                `+NMMMMMMMMMMMMMMMM:         .mMMMMMMMMMMMMMMMN+       +MMMMMMMMMMMMMMMMd.                 /NMMMMMMMMMMMMMN.sMMMMMMMMMMMMMMd`
sMMMMMMMMMMMMMMM+                                      oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMN-                  `mMMMMMMMMMMMMMMMh       yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:         .dMMMMMMMMMMMMMMMMMh-                     `+mMMMMMMMMMMMMMMMMM/         -NMMMMMMMMMMMMMMd.                  -NMMMMMMMMMMMMMMMo          `yMMMMMMMMMMMMMMMMo`   `yMMMMMMMMMMMMMMMMs                  -mMMMMMMMMMMMMMN/ `dMMMMMMMMMMMMMMs
sMMMMMMMMMMMMMMM+                                      oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMN-                   oMMMMMMMMMMMMMMMm       yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:         yMMMMMMMMMMMMMMMMm:                         `sMMMMMMMMMMMMMMMMN:        -NMMMMMMMMMMMMMMd.                   yMMMMMMMMMMMMMMMy            +NMMMMMMMMMMMMMMMh` .hMMMMMMMMMMMMMMMN/                  `dMMMMMMMMMMMMMMy   :NMMMMMMMMMMMMMM+
sMMMMMMMMMMMMMMM+                                      oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMN-                   sMMMMMMMMMMMMMMMd       yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:        /MMMMMMMMMMMMMMMMd.                            oNMMMMMMMMMMMMMMMd`       -NMMMMMMMMMMMMMMd.                  `hMMMMMMMMMMMMMMMy             :mMMMMMMMMMMMMMMMd:mMMMMMMMMMMMMMMMm-                   sMMMMMMMMMMMMMMm`    +MMMMMMMMMMMMMMN-
sMMMMMMMMMMMMMMMhssssssssssssssssssssssssssss-         oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMN-                  /MMMMMMMMMMMMMMMMy       yMMMMMMMMMMMMMMMNmmmmmmmmmmmmmmmmmmmmmmmmmMMMMMMMMMMMMMMMM:       `hMMMMMMMMMMMMMMMm.                              sMMMMMMMMMMMMMMMM:       -NMMMMMMMMMMMMMMd.                 `sMMMMMMMMMMMMMMMMo              .hMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMh.                   +MMMMMMMMMMMMMMN/     `hMMMMMMMMMMMMMMd`
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM/         oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMN-               ./hMMMMMMMMMMMMMMMMM:       yMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM:       -NMMMMMMMMMMMMMMM+                               `mMMMMMMMMMMMMMMMy       -NMMMMMMMMMMMMMMd.              `-omMMMMMMMMMMMMMMMMN.               `oMMMMMMMMMMMMMMMMMMMMMMMMMMMMNo                    -mMMMMMMMMMMMMMMs       -mMMMMMMMMMMMMMMy
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM/         oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMddddddddddddddmNMMMMMMMMMMMMMMMMMMMy`       yMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM:       /MMMMMMMMMMMMMMMm.                                sMMMMMMMMMMMMMMMd`      -NMMMMMMMMMMMMMMNddddddddddddddmNMMMMMMMMMMMMMMMMMMMs                  /NMMMMMMMMMMMMMMMMMMMMMMMMMN:                    `dMMMMMMMMMMMMMMd`        /MMMMMMMMMMMMMMM+
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM/         oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMh`        yMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM:       oMMMMMMMMMMMMMMMm                                 +MMMMMMMMMMMMMMMd.      -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMy`                   .mMMMMMMMMMMMMMMMMMMMMMMMd.                     yMMMMMMMMMMMMMMN:         `yMMMMMMMMMMMMMMM-
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM/         oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMy`         yMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM:       oMMMMMMMMMMMMMMMm                                 +MMMMMMMMMMMMMMMd.      -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNs                      `yMMMMMMMMMMMMMMMMMMMMMy                      +MMMMMMMMMMMMMMMo           .mMMMMMMMMMMMMMMd.
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM/         oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMm/           yMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM:       /MMMMMMMMMMMMMMMm.                                sMMMMMMMMMMMMMMMd`      -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMh.                         oNMMMMMMMMMMMMMMMMMM/                      -MMMMMMMMMMMMMMMh`            :NMMMMMMMMMMMMMMh
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM/         oMMMMMMMMMMMMMMMd                        -NMMMMMMMMMMMMMMN:         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMd/`            yMMMMMMMMMMMMMMMNNNNNNNNNNNNNNNNNNNNNNNNNNMMMMMMMMMMMMMMMM:       -NMMMMMMMMMMMMMMM+                               `mMMMMMMMMMMMMMMMy       -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNy-                            :mMMMMMMMMMMMMMMMm-                      .dMMMMMMMMMMMMMMN-              oMMMMMMMMMMMMMMMo
sMMMMMMMMMMMMMMMs............................`         oMMMMMMMMMMMMMMMm                        :NMMMMMMMMMMMMMMN-         `dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMmh+.               yMMMMMMMMMMMMMMM+`````````````````````````dMMMMMMMMMMMMMMM:       `hMMMMMMMMMMMMMMMm.                              sMMMMMMMMMMMMMMMM:       -NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNds:`                               oMMMMMMMMMMMMMMMo                       yMMMMMMMMMMMMMMMo```````````````.dMMMMMMMMMMMMMMN/
sMMMMMMMMMMMMMMM+                                      /MMMMMMMMMMMMMMMN:                       sMMMMMMMMMMMMMMMm.         `dMMMMMMMMMMMMMMMmmmmmmmmmmmmmmmmmmmdhyo/.`                  yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:        /MMMMMMMMMMMMMMMMd.                            oNMMMMMMMMMMMMMMMd        -NMMMMMMMMMMMMMMNmmmmmmmmMMMMMMMMMMMMMMMMd`                                  oMMMMMMMMMMMMMMMo                      oMMMMMMMMMMMMMMMMNNNNNNNNNNNNNNNNNNMMMMMMMMMMMMMMMm.
sMMMMMMMMMMMMMMM+                                      -NMMMMMMMMMMMMMMMd.                     :NMMMMMMMMMMMMMMMh`         `dMMMMMMMMMMMMMMN-````````````````                           yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:         yMMMMMMMMMMMMMMMMm:                         `sMMMMMMMMMMMMMMMMN:        -NMMMMMMMMMMMMMMd.```````/NMMMMMMMMMMMMMMMd.                                 oMMMMMMMMMMMMMMMo                     :NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMh`
sMMMMMMMMMMMMMMM+                                      `hMMMMMMMMMMMMMMMMd.                   /NMMMMMMMMMMMMMMMM+          `dMMMMMMMMMMMMMMN-                                           yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:         .dMMMMMMMMMMMMMMMMMy.                     `/mMMMMMMMMMMMMMMMMM+         -NMMMMMMMMMMMMMMd.        :MMMMMMMMMMMMMMMMm.                                oMMMMMMMMMMMMMMMo                    .mMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMs
sMMMMMMMMMMMMMMM+                                       -MMMMMMMMMMMMMMMMMNs.               :yMMMMMMMMMMMMMMMMMd`          `dMMMMMMMMMMMMMMN-                                           yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:          .mMMMMMMMMMMMMMMMMMMd/.                :sNMMMMMMMMMMMMMMMMMNo          -NMMMMMMMMMMMMMMd.         /NMMMMMMMMMMMMMMMm-                               oMMMMMMMMMMMMMMMo                   `yMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN/
sMMMMMMMMMMMMMMMy/////////////////////////////           oMMMMMMMMMMMMMMMMMMMmy+:-.```.-/+ymMMMMMMMMMMMMMMMMMMN:           `dMMMMMMMMMMMMMMN-                                           yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:           .hMMMMMMMMMMMMMMMMMMMMmyo/:..`..-:/shNMMMMMMMMMMMMMMMMMMMN/           -NMMMMMMMMMMMMMMd.          :MMMMMMMMMMMMMMMMN/                              oMMMMMMMMMMMMMMMo                   oMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMm-
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`           oMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN:            `dMMMMMMMMMMMMMMN-                                           yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:            `oNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMd-            -NMMMMMMMMMMMMMMd.           /NMMMMMMMMMMMMMMMM+                             oMMMMMMMMMMMMMMMo                  /NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMd`
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`            +NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMm-             `dMMMMMMMMMMMMMMN-                                           yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:              -yMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN/`             -NMMMMMMMMMMMMMMd.            :NMMMMMMMMMMMMMMMMo                            oMMMMMMMMMMMMMMMo                 .mMMMMMMMMMMMMMMMNhhhhhhhhhhhhhhhhhhhhhhhhhdMMMMMMMMMMMMMMMMs
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`             -hMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNs`              `dMMMMMMMMMMMMMMN-                                           yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:                :yNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMm+`               -NMMMMMMMMMMMMMMd.             /NMMMMMMMMMMMMMMMMs`                          oMMMMMMMMMMMMMMMo                `hMMMMMMMMMMMMMMMM/                         `hMMMMMMMMMMMMMMMM+
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`               :hMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNy-                `dMMMMMMMMMMMMMMN-                                           yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:                  .omMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNh:`                 -NMMMMMMMMMMMMMMd.              /NMMMMMMMMMMMMMMMMh`                         oMMMMMMMMMMMMMMMo                sMMMMMMMMMMMMMMMMy                           .NMMMMMMMMMMMMMMMm-
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`                 .odMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNd+.                  `dMMMMMMMMMMMMMMN-                                           yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:                     -odMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNy/`                    -NMMMMMMMMMMMMMMd.               /NMMMMMMMMMMMMMMMMh.                        oMMMMMMMMMMMMMMMo               /MMMMMMMMMMMMMMMMm.                            +NMMMMMMMMMMMMMMMm`
sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM`                    ./sdNMMMMMMMMMMMMMMMMMMMMMMMMMNhs:`                     `dMMMMMMMMMMMMMMN-                                           yMMMMMMMMMMMMMMM+                         dMMMMMMMMMMMMMMM:                        `:ohmMMMMMMMMMMMMMMMMMMMMMMMNdy+-`                       -NMMMMMMMMMMMMMMd.                /NMMMMMMMMMMMMMMMMm.                       oMMMMMMMMMMMMMMMo              -mMMMMMMMMMMMMMMMM:                              yMMMMMMMMMMMMMMMMy
-/////////////////////////////////////////////                          .:+osyhdmmmNNNmmddhyso/:`                           :///////////////`                                           -///////////////.                         :///////////////`                             `-/+syhdmmmNNmmddhyo+:.`                            `///////////////:`                 -/////////////////-                       -///////////////-              -////////////////:                               `/////////////////`
*/

//variabile per capire quale droga è stata scelta
int droga = 0;
//variabile per capire in che livello si trova l'utente
int livello = 0;
//variabile font
PFont font;
//variabili per l'animazione del terzo elemento del menù
float menu3size = 24;
float menu3opacity = 255;
boolean decreasing = true;
//variabili per importare e impostare il suono

SoundFile menuMove;
SoundFile tooMuchText;
SoundFile lvlSelect;
SoundFile lvlComplete;
SoundFile lvlSolved;
SoundFile bangarang;
SoundFile luis;
SoundFile cyma;
SoundFile fortnite;
boolean playSound = true;
//variabili per importare e impostare il video

Movie allucinogeni;
//imposto alcune variabili per l'hover del primo elemento del menù
boolean hover1 = true;
float menu1Opacity = 255;
float hoverMenu1Pos = 0;
//variabili primo livello allucinogeni
String s = "";
//inizializzo un timer
Timer b_timer;
String b = ""; // stringa di accumulo cannabinoidi
float cursorStart = 300-71;
float cursorMove = 17;
//imposto alcune variabili per la posizione del secondo elemento del menù
float menu2x = width/2;
float menu2y = height/2 + 50;
//variabile per passare liv 1
String DrogaLv0 = "i'm fine";
//easter egg
String EasterEgg = "jenkin27";
String EasterEgg_Bangarang = "skrillex";
String EasterEgg_Luis = "luis sal";
String EasterEgg_Fortnite = "fortnite";
String stringalv3 = "I'M FINE";

//dichiaro la booleana che permette al suono lvlSolved di ripetersi più volte
boolean solved = true;
//varibili lv1d3
float msAttuali;
//variabile per accertamento nuvo Livello
boolean newLevel = true;
//variabile contatore terzo livello cannabinoidi
int contatore = 0;
// boolean done = true;
// int test = 100;

int xfine = 150;
int xiniz = 0;
int yfine = 50;
int yiniz = 25;
int ciclofine;
int numpoint = 60;

boolean gameOver = true;

public void setup() {
  
  //carico la font nel programma
  font = loadFont("DeterminationMonoWeb-48.vlw");
  textFont(font);
  //carico il file audio dell'hover del menù
  menuMove = new SoundFile(this, "menuMove.wav");
  //carico il file audio del tooMuchText
  tooMuchText = new SoundFile(this, "tooMuchText.wav");
  //carico il file audio "lvlSelect"
  lvlSelect = new SoundFile(this, "lvlSelect.wav");
  //carico il file audio "lvlComplete"
  lvlComplete = new SoundFile(this, "lvlComplete.wav");
  //carico il file audio "lvlSolved"
  lvlSolved = new SoundFile(this, "lvlSolved.wav");
  //carico il file audio "bangarang"
  bangarang = new SoundFile(this, "bangarang.mp3");
  //carico il file audio "luis"
  luis = new SoundFile(this, "luis.mp3");
  //carico il file audio "cyma"
    cyma = new SoundFile(this, "cyma.mp3");
  //carico il file audio "fortnite"
  fortnite = new SoundFile(this, "fortnite.mp3");
  //carico il file video "allucinogeni"
  allucinogeni = new Movie(this, "allucinogeni.mp4");
  allucinogeni.loop();
  b_timer = new Timer();
}


public void draw() {
  println(s);
  background(0);
  fill(255);

  //MENU PRINCIPALE
  if (droga == 0) {

    //scrivo il titolo del gioco
    textAlign(CENTER);
    textSize(48);
    text("EUPHORYA", width/2, height/2-100);
    //disegno il primo tasto
    textSize(24);
    text("Hallucinogens", width/2, height/2);
    //disegno il secondo tasto
    textSize(24);
    text("Stimulants", menu2x, menu2y);
    //disegno il terzo tasto
    fill(255, menu3opacity);
    textSize(menu3size);
    text("Cannabinoids", width/2, height/2+100);
    fill(255);

    //codifico la logica dell'hover dei tasti, ogni else un diverso tasto
    if (mouseX > width/2 - 75 && mouseX < width/2 +75 && mouseY > height/2-15 && mouseY < height/2) { //il mouse si trova sul primo elemento
      //cambio il cursore del mouse
      cursor(HAND);
      //riproduco l'elemento musicale
      if (playSound) {
        menuMove.play();
        playSound = false;
      }
      //imposto il movimento intorno alla parola
      if (menu1Opacity < 0) {
        hoverMenu1Pos = 0;
        menu1Opacity = 255;
      }
      if (hover1) {
        fill(255, menu1Opacity);
        text("Hallucinogens", width/2 + hoverMenu1Pos, height/2 + hoverMenu1Pos);
        text("Hallucinogens", width/2 - hoverMenu1Pos, height/2 - hoverMenu1Pos);
        hoverMenu1Pos = hoverMenu1Pos + 0.1f;
        menu1Opacity = menu1Opacity - 2;
      }
      //reimposto le variabili in modo da permettere il loop
      else {
        fill(255);
        hoverMenu1Pos = 0;
        menu1Opacity = 255;
      }
      //imposto la logica per la quale il click mi porta a quella sezione del codice
      if (mousePressed) {
        droga = 1;
        lvlSelect.play();
      }
    } else if (mouseX > width/2 - 60 && mouseX < width/2 + 60 && mouseY > height/2+35 && mouseY < height/2+50) { //il mouse si trova sul secondo elemento
      //cambio il cursore del mouse
      cursor(HAND);
      //riproduco l'elemento musicale
      if (playSound) {
        menuMove.play();
        playSound = false;
      }
      //imposto il movimento, il colore e la dimensione del testo casuale intorno alla parola
      float menu1x = random(width/2-10, width/2+10);
      float menu1y = random(height/2+40, height/2+60);
      textSize(24);
      fill(random(255), random(255), random(255));
      //disegno la parola
      text("Stimulants", menu1x, menu1y);
      //ripristino il colore degli altri elementi nel menu
      fill(255);
      //imposto la logica per la quale il click mi porta a quella sezione del codice
      if (mousePressed) {
        droga = 2;
        lvlSelect.play();
      }
    } else if (mouseX > width/2 - 75 && mouseX < width/2 + 75 && mouseY > height/2 + 85 && mouseY < height/2 + 100) { //il mouse si trova sul terzo elemento
      //cambio il cursore del mouse
      cursor(HAND);
      //riproduco l'elemento musicale
      if (playSound) {
        menuMove.play();
        playSound = false;
      }
      //imposto colore ed opacità della parola
      if (decreasing) {
        menu3size = menu3size - 0.1f;
        menu3opacity = menu3opacity - 2;
        if (menu3size < 18) {
          decreasing = false;
        }
      }
      if (!decreasing) {
        menu3size = menu3size + 0.1f;
        menu3opacity = menu3opacity + 2;
        if (menu3size > 32) {
          decreasing = true;
        }
      }
      if (mousePressed) {
        droga = 3;
        lvlSelect.play();
      }
      // fill(255);
    } else {
      // il muose non è su nessun pulsante
      playSound = true;
      menu3size = 24;
      menu2x = width/2;
      menu2y = height/2 + 50;
      menu3opacity = 255;
      cursor(ARROW);
      hoverMenu1Pos = 0;
      menu1Opacity = 255;
    }
  }

  // allucinogeni
  if (droga == 1 ) {
    if (livello == 0) {
      textAlign(CENTER);
      textSize(30);
      text("How to play:", width/2, height/2-150);
      textSize(30);
      text("Just write \"I'm fine\"", width/2, height/2-100);
      textSize(36);
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      textAlign(LEFT);
      text(s.toUpperCase(), width/2-72, height/2+30);
      if (DrogaLv0.equals(s)) {
        if (solved) {
          lvlSolved.play();
          solved = false;
        }
        textAlign(CENTER);
        text("DONE", width/2, height/2+115);
        //click per livello 2
        if (mouseX > width/2 - 35 && mouseX < width/2 + 35 && mouseY > height/2+95 && mouseY < height/2+115 && mousePressed) {
          livello = 1;
          lvlComplete.play();
        }
      }
      if (EasterEgg.equals(s)) {
        if (solved) {
          cyma.play();
          solved = false;
        }
      }
      if (EasterEgg_Bangarang.equals(s)) {
        if (solved) {
          bangarang.play();
          solved = false;
        }
      }
      if (EasterEgg_Luis.equals(s)) {
        if (solved) {
          luis.play();
          solved = false;
        }
      }
      if (EasterEgg_Fortnite.equals(s)) {
        if (solved) {
          fortnite.play();
          solved = false;
        }
      }
    }

    if (livello == 1) {
      if (newLevel) {
        s = "";
        newLevel = false;
        cursorStart = 300-71;
        solved = true;
      }
      image(allucinogeni,-60,0);
      textAlign(LEFT);
      textSize(20);
      text("Level 1", 10, 20);
      textAlign(CENTER);
      textSize(36);
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      textAlign(LEFT);
      text(s.toUpperCase(), width/2-72, height/2+30);
      if (DrogaLv0.equals(s)) {
        if (solved) {
          lvlSolved.play();
          solved = false;
        }
        textAlign(CENTER);
        text("DONE", width/2, height/2+115);
        //click per livello 2
        if (mouseX > width/2 - 35 && mouseX < width/2 + 35 && mouseY > height/2+95 && mouseY < height/2+115 && mousePressed) {
          livello = 2;
          lvlComplete.play();
          newLevel = true;
        }
      }
    }

    if (livello == 2) {
      if (newLevel) {
        s = "";
        newLevel = false;
        cursorStart = 300-71;
        solved = true;
      }
      image(allucinogeni,-60,0);
      textAlign(LEFT);
      textSize(20);
      text("Level 2", 10, 20);
      textAlign(CENTER);
      textSize(36);
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      textAlign(LEFT);
      text(s.toUpperCase(), width/2-72, height/2+30);
      if (DrogaLv0.equals(s)) {
        if (solved) {
          lvlSolved.play();
          solved = false;
        }
        textAlign(CENTER);
        text("DONE", width/2, height/2+115);
        //click per livello 2
        if (mouseX > width/2 - 35 && mouseX < width/2 + 35 && mouseY > height/2+95 && mouseY < height/2+115 && mousePressed) {
          livello = 3;
          lvlComplete.play();
          newLevel = true;
        }
      }
    }

    if (livello == 3) {
      if (newLevel) {
        s = "";
        newLevel = false;
        cursorStart = 300-71;
        solved = true;
      }
      textAlign(LEFT);
      textSize(20);
      textAlign(CENTER);
      textSize(36);
      textAlign(LEFT);
      fill(255);

      text(stringalv3, xiniz, yiniz);
      text(stringalv3, xfine, yiniz);
      text(stringalv3, (2 * xfine), yiniz);
      text(stringalv3, (3 * xfine), yiniz);

      text(stringalv3, xiniz, yfine);
      text(stringalv3, xfine, yfine);
      text(stringalv3, (2 * xfine), yfine);
      text(stringalv3, (3 * xfine), yfine);

      text(stringalv3, xiniz, 2 * yfine - yiniz);
      text(stringalv3, xfine, 2 * yfine - yiniz);
      text(stringalv3, (2 * xfine), 2 * yfine - yiniz);
      text(stringalv3, (3 * xfine), 2 * yfine - yiniz);

      text(stringalv3, xiniz, 3 * yfine - 2 * yiniz);
      text(stringalv3, xfine, 3 * yfine - 2 * yiniz);
      text(stringalv3, (2 * xfine), 3 * yfine - 2 * yiniz);
      text(stringalv3, (3 * xfine), 3 * yfine - 2 * yiniz);

      text(stringalv3, xiniz, 4 * yfine - 3 * yiniz);
      text(stringalv3, xfine, 4 * yfine - 3 * yiniz);
      text(stringalv3, (2 * xfine), 4 * yfine - 3 * yiniz);
      text(stringalv3, (3 * xfine), 4 * yfine - 3 * yiniz);

      text(stringalv3, xiniz, 5 * yfine - 4 * yiniz);
      text(stringalv3, xfine, 5 * yfine - 4 * yiniz);
      text(stringalv3, (2 * xfine), 5 * yfine - 4 * yiniz);
      text(stringalv3, (3 * xfine), 5 * yfine - 4 * yiniz);

      text(stringalv3, xiniz, 6 * yfine - 5 * yiniz);
      text(stringalv3, xfine, 6 * yfine - 5 * yiniz);
      text(stringalv3, (2 * xfine), 6 * yfine - 5 * yiniz);
      text(stringalv3, (3 * xfine), 6 * yfine - 5 * yiniz);

      text(stringalv3, xiniz, 7 * yfine - 6 * yiniz);
      text(stringalv3, xfine, 7 * yfine - 6 * yiniz);
      text(stringalv3, (2 * xfine), 7 * yfine - 6 * yiniz);
      text(stringalv3, (3 * xfine), 7 * yfine - 6 * yiniz);

      text(stringalv3, xiniz, 8 * yfine - 7 * yiniz);
      text(stringalv3, xfine, 8 * yfine - 7 * yiniz);
      text(stringalv3, (2 * xfine), 8 * yfine - 7 * yiniz);
      text(stringalv3, (3 * xfine), 8 * yfine - 7 * yiniz);

      text(stringalv3, xiniz, 9 * yfine - 8 * yiniz);
      text(stringalv3, xfine, 9 * yfine - 8 * yiniz);
      text(stringalv3, (2 * xfine), 9 * yfine - 8 * yiniz);
      text(stringalv3, (3 * xfine), 9 * yfine - 8 * yiniz);

      text(stringalv3, xiniz, 10 * yfine - 9 * yiniz);
      text(stringalv3, xfine, 10 * yfine - 9 * yiniz);
      text(stringalv3, (2 * xfine), 10 * yfine - 9 * yiniz);
      text(stringalv3, (3 * xfine), 10 * yfine - 9 * yiniz);

      text(stringalv3, xiniz, 11 * yfine - 10 * yiniz);
      text(stringalv3, xfine, 11 * yfine - 10 * yiniz);
      text(stringalv3, (2 * xfine), 11 * yfine - 10 * yiniz);
      text(stringalv3, (3 * xfine), 11 * yfine - 10 * yiniz);

      text(stringalv3, xiniz, 12 * yfine - 11 * yiniz);
      text(stringalv3, xfine, 12 * yfine - 11 * yiniz);
      text(stringalv3, (2 * xfine), 12 * yfine - 11 * yiniz);
      text(stringalv3, (3 * xfine), 12 * yfine - 11 * yiniz);

      text(stringalv3, xiniz, 13 * yfine - 12 * yiniz);
      text(stringalv3, xfine, 13 * yfine - 12 * yiniz);
      text(stringalv3, (2 * xfine), 13 * yfine - 12 * yiniz);
      text(stringalv3, (3 * xfine), 13 * yfine - 12 * yiniz);

      text(stringalv3, xiniz, 14 * yfine - 13 * yiniz);
      text(stringalv3, xfine, 14 * yfine - 13 * yiniz);
      text(stringalv3, (2 * xfine), 14 * yfine - 13 * yiniz);
      text(stringalv3, (3 * xfine), 14 * yfine - 13 * yiniz);

      text(stringalv3, xiniz, 15 * yfine - 14 * yiniz);
      text(stringalv3, xfine, 15 * yfine - 14 * yiniz);
      text(stringalv3, (2 * xfine), 15 * yfine - 14 * yiniz);
      text(stringalv3, (3 * xfine), 15 * yfine - 14 * yiniz);

      text(stringalv3, xiniz, 16 * yfine - 15 * yiniz);
      text(stringalv3, xfine, 16 * yfine - 15 * yiniz);
      text(stringalv3, (2 * xfine), 16 * yfine - 15 * yiniz);
      text(stringalv3, (3 * xfine), 16 * yfine - 15 * yiniz);

      if(s.length() == 1){
        stringalv3 = "R'M FINE";
      }

      if(s.length() == 2){
        stringalv3 = "R M FINE";
      }

      if(s.length() == 3){
        stringalv3 = "R U FINE";
      }

      if(s.length() == 4){
        stringalv3 = "R U FANE";
      }

      if(s.length() == 5){
        stringalv3 = "R U SANE";
      }

      if(s.length() == 6){
        stringalv3 = "R U SUNE";
      }

      if(s.length() == 7){
        stringalv3 = "R U SURE";
      }

      if(s.length() == 8){
        for(ciclofine = 0; ciclofine <= 60; ciclofine++){
          fill(255, 0, 0);
          text("?", random(0, width), random(0, height));
          tooMuchText.play();
        }
      }



      // if(done){
      //   if(test <= 0){
      //     done = false;
      //   }
      //   text("DONE", width/2, height/2);
      //   test = test - 3;
      // } else {
      //   if(test > 100){
      //     done = true;
      //   }
      //   text("GONE", width/2, height/2);
      //   test = test + 6;
      // }
    }

    if (livello == 4) {
      textSize(48);
      text("CONGRATULATIONS!", width/2, height/2);
      textAlign(CENTER);
      textSize(36);
      text("THANK YOU", width/2, height/2+120);
      textSize(18);
      text("Press any key to exit, and enjoy your sticker!", width/2, height/2 + 140);
      if (gameOver) {
        lvlSelect.play();
        gameOver = false;
      }
      //click per uscire dal gioco
      if (keyPressed) {
        exit();
      }
    }

  }

  // stimolanti
  if (droga == 2 ) {
    if (livello == 0) {
      textAlign(CENTER);
      textSize(48);
      text("COMING SOON", width/2, height/2);
      textAlign(CENTER);
      textSize(36);
      text("BACK", width/2, height/2+150);
      //click per livello 2
      if (mouseX > width/2 - 35 && mouseX < width/2 + 35 && mouseY > height/2+130 && mouseY < height/2+150 && mousePressed) {
        droga = 0;
        tooMuchText.play();
      }
    }
  }


  // cannabinoidi
  if (droga == 3 ) {
    if (livello == 0) {
      textAlign(CENTER);
      textSize(30);
      text("How to play:", width/2, height/2-150);
      textSize(30);
      text("Just write \"I'm fine\"", width/2, height/2-100);
      textSize(36);
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      textAlign(LEFT);
      text(s.toUpperCase(), width/2-72, height/2+30);
      if (DrogaLv0.equals(s)) {
        if (solved) {
          lvlSolved.play();
          solved = false;
        }
        textAlign(CENTER);
        text("DONE", width/2, height/2+115);
        //click per livello 2
        if (mouseX > width/2 - 35 && mouseX < width/2 + 35 && mouseY > height/2+95 && mouseY < height/2+115 && mousePressed) {
          livello = 1;
          lvlComplete.play();
        }
      }
      if (EasterEgg.equals(s)) {
        if (solved) {
          cyma.play();
          solved = false;
        }
      }
      if (EasterEgg_Bangarang.equals(s)) {
        if (solved) {
          bangarang.play();
          solved = false;
        }
      }
      if (EasterEgg_Luis.equals(s)) {
        if (solved) {
          luis.play();
          solved = false;
        }
      }
      if (EasterEgg_Fortnite.equals(s)) {
        if (solved) {
          fortnite.play();
          solved = false;
        }
      }
    }

    if (livello == 1) {
      textAlign(LEFT);
      textSize(20);
      text("Level 1", 10, 20);
      textAlign(CENTER);
      textSize(36);
      if (newLevel) {
        s = "";
        newLevel = false;
        cursorStart = 300-71;
        solved = true;
      }
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      textAlign(LEFT);
      text(s.toUpperCase(), width/2-72, height/2+30);

      if (b_timer.check(PApplet.parseInt(random(2000,4000))) == true) {
        if (b.length() > 0) {
          s = s + b.substring(0, 1);
          cursorStart = cursorStart + cursorMove;
          b = b.substring(1, b.length());
        }
        b_timer.start();
      }
      if (DrogaLv0.equals(s)) {
        if (solved) {
          lvlSolved.play();
          solved = false;
        }
        textAlign(CENTER);
        text("DONE", width/2, height/2+115);
        //click per livello 2
        if (mouseX > width/2 - 35 && mouseX < width/2 + 35 && mouseY > height/2+95 && mouseY < height/2+115 && mousePressed) {
          livello = livello + 1;
          lvlComplete.play();
          newLevel = true;
        }
      }
    }

    if (livello == 2) {
      textAlign(LEFT);
      textSize(20);
      text("Level 2", 10, 20);
      textAlign(CENTER);
      textSize(menu3size + 12);

      if (newLevel) {
        s = "";
        newLevel = false;
        cursorStart = 300-71;
        solved = true;
      }
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      fill(255, menu3opacity);
      textAlign(LEFT);
      text(s.toUpperCase(), width/2-72, height/2+30);
      if (b_timer.check(PApplet.parseInt(random(2000.0f, 4000.0f))) == true) {
        if (b.length() > 0) {
          s = s + b.substring(0, 1);
          cursorStart = cursorStart + cursorMove;
          b = b.substring(1, b.length());
        }
        b_timer.start();
      }
      if (decreasing) {
        menu3size = menu3size - 0.2f;
        menu3opacity = menu3opacity - 15;
        if (menu3size < 18) {
          decreasing = false;
        }
      }
      if (!decreasing) {
        menu3size = menu3size + 0.2f;
        menu3opacity = menu3opacity + 14.3f;
        if (menu3size > 32) {
          decreasing = true;
        }
      }
      if (DrogaLv0.equals(s)) {
        if (solved) {
          lvlSolved.play();
          solved = false;
        }
        textAlign(CENTER);
        text("DONE", width/2, height/2+115);
        //click per livello 2
        if (mouseX > width/2 - 35 && mouseX < width/2 + 35 && mouseY > height/2+95 && mouseY < height/2+115 && mousePressed) {
          livello = livello + 1;
          lvlComplete.play();
          newLevel = true;
          menu3size = 24;
          menu3opacity = 255;
        }
      }
    }

    if (livello == 3) {
      textAlign(LEFT);
      textSize(20);
      text("Level 3", 10, 20);
      textAlign(CENTER);
      textSize(menu3size + 12);

      if (newLevel) {
        s = "";
        newLevel = false;
        cursorStart = 300-71;
        solved = true;
      }
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      fill(255, menu3opacity);
      textAlign(LEFT);
      text(s.toUpperCase(), width/2-72, height/2+30);
      if (b_timer.check(PApplet.parseInt(random(2000.0f, 4000.0f))) == true) {
        if (b.length() > 0) {
          s = s + b.substring(0, 1);
          cursorStart = cursorStart + cursorMove;
          b = b.substring(1, b.length());
        }
        b_timer.start();
      }
      if (decreasing) {
        menu3size = menu3size - 0.2f;
        menu3opacity = menu3opacity - 15;
        if (menu3size < 18) {
          decreasing = false;
        }
      }
      if (!decreasing) {
        menu3size = menu3size + 0.2f;
        menu3opacity = menu3opacity + 14.3f;
        if (menu3size > 32) {
          decreasing = true;
        }
      }
      if (DrogaLv0.equals(s)) {
        if (solved) {
          lvlSolved.play();
          solved = false;
        }
        textAlign(CENTER);
        text("DONE", width/2, height/2+115);
        //click per livello 2
        if (mouseX > width/2 - 35 && mouseX < width/2 + 35 && mouseY > height/2+95 && mouseY < height/2+115 && mousePressed) {
          livello = livello + 1;
          lvlComplete.play();
          newLevel = true;
        }
      }
    }

    if (livello == 4) {
      textSize(48);
      text("CONGRATULATIONS!", width/2, height/2);
      textAlign(CENTER);
      textSize(36);
      text("THANK YOU", width/2, height/2+120);
      textSize(18);
      text("Press any key to exit, and enjoy your sticker!", width/2, height/2 + 140);
      if (gameOver) {
        lvlSelect.play();
        gameOver = false;
      }
      //click per uscire dal gioco
      if (keyPressed) {
        exit();
      }
    }
  }
}

public void keyReleased() {
  if (droga != 0 && livello == 0) {
    if (key != BACKSPACE && key != DELETE) {
      if (s.length() < 8) {
        s = s + key;
      } else {
        tooMuchText.play();
      }
    }
    if (key != BACKSPACE && key != DELETE && cursorStart <(300-71+126)) {
      cursorStart = cursorStart + cursorMove;
    }
  } else if (droga == 3 && livello == 1 && key != BACKSPACE && key != DELETE) {
    if (s.length() < 8) {    //meccanica di gioco primo livello cannabinoidi
      b = b + key;
    } else {
      tooMuchText.play();
    }
    if (b_timer.state == false) {
      b_timer.start();
    }
  } else if (droga == 3 && livello == 2 && key != BACKSPACE && key != DELETE) {
    if (s.length() < 8) {
      b = b + key;
    } else {
      tooMuchText.play();
    }
    if (b_timer.state == false) {
      b_timer.start();
    }
  } else if (droga == 3 && livello == 3 && key != BACKSPACE && key != DELETE) {
    if (s.length() < 8) {
      contatore = contatore + 1;
      if(contatore > 2) {
        b = b + key;
        contatore = 0;
      }
    } else {
      tooMuchText.play();
    }
    if (b_timer.state == false) {
      b_timer.start();
      }
  } else if (droga == 1 && livello == 1 && key != BACKSPACE && key != DELETE) {
    if (key != BACKSPACE && key != DELETE) {
      if (s.length() < 8) {
        s = s + key;
      } else {
        tooMuchText.play();
      }
    }
    if (key != BACKSPACE && key != DELETE && cursorStart <(300-71+126)) {
      cursorStart = cursorStart + cursorMove;
    }
  } else if (droga == 1 && livello == 2 && key != BACKSPACE && key != DELETE) {
    if (key != BACKSPACE && key != DELETE) {
      if (s.length() < 8) {

        if(key == 'q'){
          s = s + 'w';
        }

        if(key == 'w'){
          s = s + 'e';
        }

        if(key == 'e'){
          s = s + 'r';
        }

        if(key == 'r'){
          s = s + 't';
        }

        if(key == 't'){
          s = s + 'y';
        }

        if(key == 'y'){
          s = s + 'u';
        }

        if(key == 'u'){
          s = s + 'i';
        }

        if(key == 'i'){
          s = s + 'o';
        }

        if(key == 'o'){
          s = s + 'p';
        }

        if(key == 'a'){
          s = s + 's';
        }

        if(key == 's'){
          s = s + 'd';
        }

        if(key == 'd'){
          s = s + 'f';
        }

        if(key == 'f'){
          s = s + 'g';
        }

        if(key == 'g'){
          s = s + 'h';
        }

        if(key == 'h'){
          s = s + 'j';
        }

        if(key == 'j'){
          s = s + 'k';
        }

        if(key == 'k'){
          s = s + 'l';
        }

        if(key == 'z'){
          s = s + 'x';
        }

        if(key == 'x'){
          s = s + 'c';
        }

        if(key == 'c'){
          s = s + 'v';
        }

        if(key == 'v'){
          s = s + 'b';
        }

        if(key == 'b'){
          s = s + 'n';
        }

        if(key == 'n'){
          s = s + 'm';
        }

        if(key == '\''){
          s = s + '\'';
        }

        if(key == ' '){
          s = s + ' ';
        } //QUI DENTRO CI SONO MILLE IF
      } else {
        tooMuchText.play();
      }
    }
  } else if (droga == 1 && livello == 3 && key != BACKSPACE && key != DELETE) {
    if (key != BACKSPACE && key != DELETE) {
      if (s.length() < 8) {
        if(s.length() == 7){
          if(key == 'y' || key == 'Y'){
            s = "";
            livello = 4;
          }
        }
        s = s + key;


      } else {
        tooMuchText.play();
      }
    }
    if (key != BACKSPACE && key != DELETE && cursorStart <(300-71+126)) {
      cursorStart = cursorStart + cursorMove;
    }
  }

  if (key == TAB) {
    droga = 0;
    livello = 0;
    s = "";
    cursorStart = 300-71;
  }
}

public void keyPressed() {
  if (key == BACKSPACE || key == DELETE) {
    s = "";
    cursorStart = 300-71;
    solved = true;
    menu3size = 24;
    menu3opacity = 255;
    if(livello == 3) {
      contatore = 0;
      livello = 0;
    }
  }
}

public void movieEvent(Movie allucinogeni){
  allucinogeni.read();
}
class Timer {

  boolean state = false;
  //ts = timestamp
  int ts;

  public void start(){
      ts = millis();
      state = true;
  }

  public void stop(){
      state = false;
  }

  public boolean check(int tempo){
    if(millis() - ts >= tempo){
      return true;
    } else {
      return false;
    }
  }

}
  public void settings() {  size(600, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "EUPHORYA" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
