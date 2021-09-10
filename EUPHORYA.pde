//variabile per capire quale droga è stata scelta
int droga = 0;

//variabile per capire in che livello si trova l'utente
int livello = 0;

//variabile per la chiusura nel glitch d1l3
int quitTimer = 0;

//variabile font
PFont font;

//variabili per l'animazione del terzo elemento del menù
float menu3size = 24;
float menu3opacity = 255;
boolean decreasing = true;

//variabili per importare e impostare il suono
import processing.sound.*;
SoundFile menuMove;
SoundFile tooMuchText;
SoundFile lvlSelect;
SoundFile lvlComplete;
SoundFile lvlSolved;
boolean playSound = true;

//imposto alcune variabili per l'hover del primo elemento del menù
boolean hover1 = true;
float menu1Opacity = 255;
float hoverMenu1Pos = 0;

//variabili primo livello allucinogeni
String s = "";
 
//dichiaro un timer
Timer b_timer;

// stringa di accumulo cannabinoidi
String b = ""; 

// queste servono per il movimento del cursorino
float cursorStart;
float originalCursorStart;
float characterWidth = 18;

//imposto alcune variabili per la posizione del secondo elemento del menù
float menu2x = width/2;
float menu2y = height/2 + 50;

//variabile per passare liv 1
String DrogaLv0 = "i'm fine";

//il lv3 di allucinogeni è strano serve una stringa (a quanto pare)
String stringalv3 = "I'M FINE";

//dichiaro la booleana che permette al suono lvlSolved di ripetersi più volte
boolean solved = true;

//varibili lv1d3
float msAttuali;

//variabile per accertamento nuvo Livello
boolean newLevel = true;

//variabile contatore terzo livello cannabinoidi
int contatore = 0;

//variabile sfondo livelli allucinogeni
float angolo;
int illusionIndex = 20;

int xfine = 150;
int xiniz = 25;
int yfine = 50;
int yiniz = 55;
int ciclofine;

boolean gameOver = true;

void setup() {
  fullScreen();
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
  b_timer = new Timer();
  cursorStart = width/2 - 70;
  originalCursorStart = width/2 - 70;
}

void draw() {
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

    // logica dell'hover dei tasti, ogni else un diverso tasto
    if (mouseX > width/2 - 75 && mouseX < width/2 +75 && mouseY > height/2-15 && mouseY < height/2) { 
      //il mouse si trova sul primo elemento
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
        hoverMenu1Pos = hoverMenu1Pos + 0.1;
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
        menu3size = menu3size - 0.1;
        menu3opacity = menu3opacity - 2;
        if (menu3size < 18) {
          decreasing = false;
        }
      }
      if (!decreasing) {
        menu3size = menu3size + 0.1;
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

  //ANCHOR allucinogeni
  if (droga == 1 ) {
    if (livello == 0) {
      textAlign(CENTER);
      textSize(30);
      text("How to play:", width/2, height/2-150);
      textSize(30);
      text("Just write \"i'm fine\"", width/2, height/2-100);
      textSize(36);
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      textAlign(LEFT);
      text(s.toLowerCase(), width/2-72, height/2+30);
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
    }

    if (livello == 1) {
      if (newLevel) {
        s = "";
        newLevel = false;
        cursorStart = originalCursorStart;
        solved = true;
      }

      float xpunto = width;
      float diametro = 150;
      int numeroDiPunti = 100;

      pushMatrix();
        noStroke();
        fill(255, 255, 255);
        translate(width/2, height/2);

        for(int a = 0; a < 360; a+=45) {
          rotate(radians(a));
          pushMatrix();
            for(int i = 0; i < numeroDiPunti; i++) {
              scale(0.95);
              rotate(radians(angolo));
              ellipse(xpunto, 0, diametro, diametro);
            }
          popMatrix();
        }
        angolo += 0.03;
      popMatrix();

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
      text(s.toLowerCase(), width/2-72, height/2+30);
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
        cursorStart = originalCursorStart;
        solved = true;
      }

      float xpunto = width;
      float diametro = 150;
      int numeroDiPunti = 100;

      pushMatrix();
        noStroke();
        fill(255, 255, 255);
        translate(width/2, height/2);

        for(int a = 0; a < 360; a+=45) {
          rotate(radians(a));
          pushMatrix();
            if(second() % 2 == 0) {
              fill(random(0,255),random(0,255),random(0,255));
            }
            for(int i = 0; i < numeroDiPunti; i++) {
              scale(0.95);
              rotate(radians(angolo));
              ellipse(xpunto, 0, diametro, diametro);
            }
          popMatrix();
        }
        angolo += 0.03;
      popMatrix();

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
      text(s.toLowerCase(), width/2-72, height/2+30);
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
        cursorStart = originalCursorStart;
        solved = true;
      }
      textAlign(LEFT);
      textSize(20);
      textAlign(CENTER);
      textSize(36);
      textAlign(LEFT);
      fill(255);

      for(int i = 0; i < floor((width/((characterWidth*8) + 20)) + 1); i++) {
        for(int j = 0; j < floor((height/55)); j++) {
          text(stringalv3, xiniz + (160 * i), yiniz * (j+1));
        }
      }
      
      switch (s.length()) {
        case 1:
          stringalv3 = "R'M FINE";
          break;
        case 2:
          stringalv3 = "R M FINE";
          break;
        case 3:
          stringalv3 = "R U FINE";
          break;
        case 4:
          stringalv3 = "R U FANE";
          break;
        case 5:
          stringalv3 = "R U SANE";
          break;
        case 6:
          stringalv3 = "R U SUNE";
          break;
        case 7:
          stringalv3 = "R U SURE";
          break;
        case 8:
          quitTimer++;
          for(ciclofine = 0; ciclofine <= 60; ciclofine++){
            fill(255, 0, 0);
            text("?", random(0, width), random(0, height));
            tooMuchText.play();
          }
          if(quitTimer >= 100) exit();
          break;
        default :
          stringalv3 = "I'M FINE";
        break;	
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

  //ANCHOR stimolanti
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

  //ANCHOR cannabinoidi
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
      text(s.toLowerCase(), width/2-72, height/2+30);
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
        cursorStart = originalCursorStart;
        solved = true;
      }
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      textAlign(LEFT);
      text(s.toLowerCase(), width/2-72, height/2+30);

      if (b_timer.check(int(random(2000,4000))) == true) {
        if (b.length() > 0) {
          s = s + b.substring(0, 1);
          cursorStart = cursorStart + characterWidth;
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
        cursorStart = originalCursorStart;
        solved = true;
      }
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      fill(255, menu3opacity);
      textAlign(LEFT);
      text(s.toLowerCase(), width/2-72, height/2+30);
      if (b_timer.check(int(random(2000.0, 4000.0))) == true) {
        if (b.length() > 0) {
          s = s + b.substring(0, 1);
          cursorStart = cursorStart + characterWidth;
          b = b.substring(1, b.length());
        }
        b_timer.start();
      }
      if (decreasing) {
        menu3size = menu3size - 0.2;
        menu3opacity = menu3opacity - 15;
        if (menu3size < 18) {
          decreasing = false;
        }
      }
      if (!decreasing) {
        menu3size = menu3size + 0.2;
        menu3opacity = menu3opacity + 14.3;
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
        cursorStart = originalCursorStart;
        solved = true;
      }
      if (second() % 2 == 0) {
        fill(255);
        rect(cursorStart, height/2+35, 14, 3);
      }
      fill(255, menu3opacity);
      textAlign(LEFT);
      text(s.toLowerCase(), width/2-72, height/2+30);
      if (b_timer.check(int(random(2000.0, 4000.0))) == true) {
        if (b.length() > 0) {
          s = s + b.substring(0, 1);
          cursorStart = cursorStart + characterWidth;
          b = b.substring(1, b.length());
        }
        b_timer.start();
      }
      if (decreasing) {
        menu3size = menu3size - 0.2;
        menu3opacity = menu3opacity - 15;
        if (menu3size < 18) {
          decreasing = false;
        }
      }
      if (!decreasing) {
        menu3size = menu3size + 0.2;
        menu3opacity = menu3opacity + 14.3;
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

void keyReleased() {
  if (droga != 0 && livello == 0) {
    if (key != BACKSPACE && key != DELETE) {
      if (s.length() < 8) {
        s = s + key;
      } else {
        tooMuchText.play();
      }
    }
    if (key != BACKSPACE && key != DELETE && cursorStart < originalCursorStart + (characterWidth * 8)) {
      cursorStart = cursorStart + characterWidth;
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
    if (key != BACKSPACE && key != DELETE && cursorStart < originalCursorStart + (characterWidth * 8)) {
      cursorStart = cursorStart + characterWidth;
    }
  } else if (droga == 1 && livello == 2 && key != BACKSPACE && key != DELETE) {
    if (key != BACKSPACE && key != DELETE) {
      /* Key if's */ if (s.length() < 8) {
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
        }
      } else {
        tooMuchText.play();
      }
    }
    if (key != BACKSPACE && key != DELETE && cursorStart < originalCursorStart + (characterWidth * 8)) {
      cursorStart = cursorStart + characterWidth;
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
    if (key != BACKSPACE && key != DELETE && cursorStart < originalCursorStart + (characterWidth * 8)) {
      cursorStart = cursorStart + characterWidth;
    }
  }

  if (key == TAB) {
    droga = 0;
    livello = 0;
    s = "";
    cursorStart = originalCursorStart;
  }
}

void keyPressed() {
  if (key == BACKSPACE || key == DELETE) {
    s = "";
    cursorStart = originalCursorStart;
    solved = true;
    menu3size = 24;
    menu3opacity = 255;
    if(livello == 3) {
      contatore = 0;
      livello = 0;
    }
  }
}
