package tests.webservice;

public class HelloProxy implements tests.webservice.Hello {
  private String _endpoint = null;
  private tests.webservice.Hello hello = null;
  
  public HelloProxy() {
    _initHelloProxy();
  }
  
  public HelloProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloProxy();
  }
  
  private void _initHelloProxy() {
    try {
      hello = (new tests.webservice.HelloServiceLocator()).getHello();
      if (hello != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hello)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hello != null)
      ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tests.webservice.Hello getHello() {
    if (hello == null)
      _initHelloProxy();
    return hello;
  }
  
  public java.lang.String helloName(java.lang.String name) throws java.rmi.RemoteException{
    if (hello == null)
      _initHelloProxy();
    return hello.helloName(name);
  }
  
  
}