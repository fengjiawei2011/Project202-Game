interface  ISubject  
{
  public void attach(IObserver ob);
  public void detach(IObserver ob);
  public void notifyObserver();
}
