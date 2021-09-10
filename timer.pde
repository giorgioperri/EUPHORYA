class Timer {

  boolean state = false;
  //ts = timestamp
  int ts;

  void start(){
      ts = millis();
      state = true;
  }

  void stop(){
      state = false;
  }

  boolean check(int tempo){
    if(millis() - ts >= tempo){
      return true;
    } else {
      return false;
    }
  }

}
