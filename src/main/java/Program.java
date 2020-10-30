public class Program {
    public static void main(String[] args) {
        Person[] people=new Person[5];
        people[0]=new Person("Ivanov Ivan Ivanovich","Driver","drive@mailbox.com","892312312",30000,36);
        people[1]=new Person("Petrov Petr Petrovich","Engineer","engineer@mailbox.com","892312420",60000,42);
        people[2]=new Person("Sidorov Ivan Ivanovich","Boss","boss@mailbox.com","892311313",100000,56);
        people[3]=new Person("Ivanova Elena Ivanovna","Accountant","bux@mailbox.com","892312314",40000,25);
        people[4]=new Person("Petrova Inna Vasilievna","Meneger","meneger@mailbox.com","892312024",35000,30);

        for(Person pers:people)
            if(pers.getAge()>40) System.out.println(pers);

    }
}
