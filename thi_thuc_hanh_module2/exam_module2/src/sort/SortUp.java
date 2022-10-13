package sort;

import model.Student;

import java.util.Comparator;

public class SortUp implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAveragePoint() == o2.getAveragePoint()){
            return 0;
        }else if (o1.getAveragePoint() >  o2.getAveragePoint()) {
            return 1;
        } else {
            return -1;
        }
    }
}
