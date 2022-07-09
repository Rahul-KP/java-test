import java.util.ArrayList;
class Zigzag {
    public String convert(String s, int numRows) {
        ArrayList<Character> a = new ArrayList<Character>();
        StringBuilder zigzag = new StringBuilder();
        
        int jump = numRows+(numRows-2);
        for(int i=0,j=0; i<s.length() && j<numRows || i-(2*j)<s.length();) {
            if(i-(j*2)!=i && i-(j*2)>0 && j!=numRows-1) {
                a.add(s.charAt(i-(j*2)));
            }
            if(i<s.length()) {
                a.add(s.charAt(i));
            }
            i += jump;
            if(i>s.length() || (i==s.length()&&a.size()!=s.length())) {
                j++;
                i=j;
            }
            if(a.size()==s.length()) {
                break;
            }
        }

        for(char c:a) {
            zigzag.append(c);
        }
        return zigzag.toString();
    }

    public static void main(String[] args) {
        Zigzag z = new Zigzag();
        String st = z.convert(args[0],Integer.parseInt(args[1]));
        System.out.println(st);
    }
}