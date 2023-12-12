public class Obj<t> {

private t value;

public Obj(){}

public Obj(t value) {
    this.value = value;
}


public t getValue() {
    return value;
}

public void setValue(t value) {
    this.value = value;
}
   
}
