/* 
User: Urmi
Date: 1/27/2020 
Time: 10:08 AM
*/

package dataStructures;

import java.util.Iterator;

public class MyIterator implements Container{

    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override
    public Iterator getIterator() {
        return new NamesIterator();
    }

    private class NamesIterator implements Iterator{

        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index ++];
            }
            return null;
        }
    }

}
