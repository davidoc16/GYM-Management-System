/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem;
import java.util.*;
/**
 *
 * @author David
 */
public class CompareNames implements Comparator<Person>{
        public int compare(Person p1, Person p2){
   	return p1.getName().compareToIgnoreCase(p2.getName());
}
}

