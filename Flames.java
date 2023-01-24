import java.util.*;
public class Flames{
    public static void main( String arg[] ){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first Name");
        String name1=sc.next();
        System.out.println("Enter the Second Name");
        String name2=sc.next();

        name1=name1.toLowerCase();
        name2=name2.toLowerCase();

        int n=name1.length();
        int m=name2.length();
        int count=0;
        String s1="",s2="";
        boolean b=true;
        for( int i=0; i<n; i++ )
        {
            b=true;
            for(int j=0; j<m; j++)
            {
                if(name1.charAt(i) == name2.charAt(j))
                {
                    s1=s1+name1.charAt(i);
                    b=false;
                    break;
                }
            }
            if(b)
                count++;
        }
        for(int j=0; j<m; j++)
        {
            b=true;
            for(int i=0; i<n; i++)
            {
                if(name1.charAt(i) == name2.charAt(j))
                {
                    s2+=name2.charAt(j);
                    b=false;
                    break;
                }
            }
            if(b)
                count++;
        }
            int n1=s1.length();
            int n2=s2.length();
            String s3="";
            s3=s3+s1.charAt(0);
            for(int i=0; i<n1; i++)
            {
                b=true;
                int l = s3.length();
                for(int j=l-1; j>=0; j--)
                {
                    if(s1.charAt(i) == s3.charAt(j))
                    {
                        b=false;
                    }
                }
                if(b)
                s3+=s1.charAt(i);
            }
        
        int x=s3.length();
        int arr1[]=new int[x];
        int arr2[]=new int[x];
        int c=0;

        for(int i=0; i<x; i++)
        {
            c=0;
            for(int j=0; j<n1; j++)
            {
                if(s3.charAt(i) == s1.charAt(j))
                    c++;
            }
            arr1[i]=c;
        }

        for(int i=0; i<x; i++)
        {
            c=0;
            for(int j=0; j<n2; j++)
            {
                if( s3.charAt(i) == s2.charAt(j) )
                    c++;
            }
            arr2[i]=c;
        }
        for(int i=0; i<x; i++)
        {
            if(arr1[i]>arr2[i])
                count+=arr1[i]-arr2[i];
            else
                count+=arr2[i]-arr1[i];
        }
        System.out.print(StrikeLetter.strike(count));

        sc.close();
    }
}
class StrikeLetter {
    public static String strike(int count){
        String f="FLAMES";
        int p=0;
        int j=6;
        while(f.length()!=1)
        {
            int np=p+count;
            while(np>j)
            {
                np-=j;
            }
            String nf="";
            for(int i=0; i<f.length(); i++)
            {
                if(i==np-1)
                    continue;
                else
                    nf+=f.charAt(i);
            }
            f=nf;
            j--;
            p=np-1;
        }
        return f;
    }
}