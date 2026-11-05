class Printer 
{
    synchronized void printDoc(String name,int pages)
    {
        System.out.println("printing doc by "+Thread.currentThread().getName());
        for(int i=0;i<pages;i++)
        {
            System.out.println(Thread.currentThread().getName()+" printing "+ name +" page no "+i+" of "+pages);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
class Pc implements Runnable {
    Printer p; 
    String docName;
    int page;
    Pc(String docName,int page,Printer p)
    {
        this.p=p;
        this.docName=docName;
        this.page=page;
    }
    public  void run()
    {
        p.printDoc(docName, page);
    }
}
public class PrinterDemo
{
    public static void main(String[] args) 
    {
        Printer p =new Printer();
        Pc pc1=new Pc("incometax", 10, p);
        Pc pc2=new Pc("java", 10, p);
        Thread t1= new Thread(pc1,"pc1");
        Thread t2= new Thread(pc2,"pc2");
        t1.start();
        t2.start();

    }
}

