import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    public class TodosTest {
        @Test
        public void addNoMatches() {
            Todos todos = new Todos();
            todos.add(new SimpleTask(1, "Купить молоко"));
            todos.add(new Epic(2, new String[]{"Испечь торт"}));
            Task[] expected = {};
            Task[] actual = todos.search("Погулять с собакой");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void addOneMatch() {
            Todos todos = new Todos();
            todos.add(new SimpleTask(1, "Испечь торт"));
            todos.add(new Epic(2, new String[]{"Погулять с собакой"}));
            Task[] expected = { new SimpleTask(1, "Испечь торт") };
            Task[] actual = todos.search("торт");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void addMultipleTasks() {
            Todos todos = new Todos();
            todos.add(new SimpleTask(1, "Испечь торт"));
            todos.add(new Epic(2, new String[]{"Погулять с собакой"}));
            Task[] expected = { new SimpleTask(1, "Испечь торт"), new Epic(2, new String[]{"Погулять с собакой"}) };
            Task[] actual = todos.search("");
            Assertions.assertArrayEquals(expected, actual);
        }


    }
