package sort;

import model.Student;

import java.util.Comparator;

public class SortDown implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o2.getAveragePoint() == o1.getAveragePoint()){
            return 0;
        }else if (o2.getAveragePoint() >  o1.getAveragePoint()) {
            return 1;
        } else {
            return -1;
        }
    }
}
