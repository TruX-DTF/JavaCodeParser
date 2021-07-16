package edu.lu.uni.serval;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class LauncherTest {

    private static final String RESOURCES_DIR = "src/test/resources/LauncherTest/";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void mainTemplate() throws IOException {
        String expectedResult = "{\"methodNames\":[\"checkNotNull\",\"checkArgument\"],\"memberReference\":[\"obj\",\"obj\",\"condition\"],\"methodInvocation\":[],\"documentation\":[\"\\r\\n * A simple utility class used to check method Preconditions.\\r\\n *\\r\\n * <pre>\\r\\n * public long divideBy(long value) {\\r\\n *   Preconditions.checkArgument(value != 0);\\r\\n *   return this.value / value;\\r\\n * }\\r\\n * </pre>\\r\\n *\\r\\n * @author Inderjeet Singh\\r\\n * @author Joel Leitch\\r\\n \"],\"className\":[\"$Gson$Preconditions\"],\"packageName\":[\"com.google.gson.internal\"],\"classNameExt\":[\"$Gson$Preconditions\",\"UnsupportedOperationException\",\"T\",\"T\",\"NullPointerException\",\"IllegalArgumentException\"],\"formalParameter\":[\"obj\",\"condition\"],\"literal\":[\"null\"]}\n";
        String filePath = RESOURCES_DIR + "$Gson$Preconditions.java";
        File file = new File(filePath);
        assertTrue("setup issue! couldn't load resources at " + filePath, file.exists());
        String[] array = new String[1];
        array[0] = file.getCanonicalPath();
        Launcher.main(array);
        String res = outContent.toString();
        assertFalse(res.isEmpty());
        assertEquals("Unexpected class parsing results.", expectedResult, res);
    }

    @Test
    public void mainNormal() throws IOException {
        String expectedResult = "{\"methodNames\":[\"get\",\"construct\",\"construct\",\"newDefaultConstructor\",\"construct\",\"newDefaultImplementationConstructor\",\"construct\",\"construct\",\"construct\",\"construct\",\"construct\",\"construct\",\"construct\",\"construct\",\"newUnsafeAllocator\",\"construct\",\"toString\"],\"memberReference\":[\"instanceCreators\",\"typeToken\",\"typeToken\",\"instanceCreators\",\"type\",\"typeCreator\",\"typeCreator\",\"type\",\"instanceCreators\",\"rawType\",\"rawTypeCreator\",\"rawTypeCreator\",\"type\",\"rawType\",\"defaultConstructor\",\"defaultConstructor\",\"type\",\"rawType\",\"defaultImplementation\",\"defaultImplementation\",\"type\",\"rawType\",\"rawType\",\"constructor\",\"constructor\",\"constructor\",\"args\",\"constructor\",\"e\",\"constructor\",\"e\",\"e\",\"rawType\",\"rawType\",\"rawType\",\"type\",\"type\",\"elementType\",\"EnumSet\",\"elementType\",\"type\",\"type\",\"rawType\",\"rawType\",\"rawType\",\"rawType\",\"type\",\"TypeToken\",\"type\",\"UnsafeAllocator\",\"unsafeAllocator\",\"rawType\",\"newInstance\",\"type\",\"e\",\"instanceCreators\"],\"methodInvocation\":[\"getType\",\"getRawType\",\"get\",\"createInstance\",\"get\",\"createInstance\",\"newDefaultConstructor\",\"newDefaultImplementationConstructor\",\"newUnsafeAllocator\",\"getDeclaredConstructor\",\"isAccessible\",\"setAccessible\",\"newInstance\",\"getTargetException\",\"isAssignableFrom\",\"isAssignableFrom\",\"isAssignableFrom\",\"getActualTypeArguments\",\"noneOf\",\"toString\",\"toString\",\"isAssignableFrom\",\"isAssignableFrom\",\"isAssignableFrom\",\"isAssignableFrom\",\"isAssignableFrom\",\"getRawType\",\"get\",\"getActualTypeArguments\",\"create\",\"newInstance\",\"toString\"],\"documentation\":[\"\\n * Returns a function that can construct an instance of a requested type.\\n \",\" first try an instance creator\",\" types must agree\",\" Next try raw type match for instance creators\",\" types must agree\",\" finally try unsafe\",\" T is the same raw type as is requested\",\" TODO: JsonParseException ?\",\" TODO: don't wrap if cause is unchecked!\",\" TODO: JsonParseException ?\",\"\\n   * Constructors for common interface types like Map and List and their\\n   * subtypes.\\n   \",\" use runtime checks to guarantee that 'T' is what it is\"],\"className\":[\"ConstructorConstructor\"],\"packageName\":[\"com.google.gson.internal\"],\"classNameExt\":[\"ConstructorConstructor\",\"Map\",\"Type\",\"InstanceCreator\",\"Map\",\"Type\",\"InstanceCreator\",\"TypeToken\",\"T\",\"ObjectConstructor\",\"T\",\"Type\",\"Class\",\"T\",\"InstanceCreator\",\"T\",\"InstanceCreator\",\"T\",\"ObjectConstructor\",\"T\",\"T\",\"InstanceCreator\",\"T\",\"InstanceCreator\",\"T\",\"ObjectConstructor\",\"T\",\"T\",\"ObjectConstructor\",\"T\",\"ObjectConstructor\",\"T\",\"Class\",\"T\",\"ObjectConstructor\",\"T\",\"Constructor\",\"T\",\"ObjectConstructor\",\"T\",\"T\",\"Object\",\"T\",\"InstantiationException\",\"RuntimeException\",\"InvocationTargetException\",\"RuntimeException\",\"IllegalAccessException\",\"AssertionError\",\"NoSuchMethodException\",\"Type\",\"Class\",\"T\",\"ObjectConstructor\",\"T\",\"Collection\",\"SortedSet\",\"ObjectConstructor\",\"T\",\"T\",\"T\",\"TreeSet\",\"Object\",\"EnumSet\",\"ObjectConstructor\",\"T\",\"T\",\"ParameterizedType\",\"Type\",\"ParameterizedType\",\"Class\",\"T\",\"Class\",\"JsonIOException\",\"JsonIOException\",\"Set\",\"ObjectConstructor\",\"T\",\"T\",\"T\",\"LinkedHashSet\",\"Object\",\"Queue\",\"ObjectConstructor\",\"T\",\"T\",\"T\",\"LinkedList\",\"Object\",\"ObjectConstructor\",\"T\",\"T\",\"T\",\"ArrayList\",\"Object\",\"Map\",\"SortedMap\",\"ObjectConstructor\",\"T\",\"T\",\"T\",\"TreeMap\",\"Object\",\"Object\",\"ParameterizedType\",\"String\",\"ParameterizedType\",\"ObjectConstructor\",\"T\",\"T\",\"T\",\"LinkedHashMap\",\"Object\",\"Object\",\"ObjectConstructor\",\"T\",\"T\",\"T\",\"LinkedTreeMap\",\"String\",\"Object\",\"Type\",\"Class\",\"T\",\"ObjectConstructor\",\"T\",\"ObjectConstructor\",\"T\",\"UnsafeAllocator\",\"T\",\"Object\",\"T\",\"Exception\",\"RuntimeException\",\"String\"],\"formalParameter\":[\"instanceCreators\",\"typeToken\",\"rawType\",\"e\",\"e\",\"e\",\"e\",\"type\",\"rawType\",\"type\",\"rawType\",\"e\"],\"literal\":[\"\\\"unchecked\\\"\",\"null\",\"\\\"unchecked\\\"\",\"null\",\"null\",\"null\",\"true\",\"\\\"unchecked\\\"\",\"null\",\"\\\"Failed to invoke \\\"\",\"\\\" with no args\\\"\",\"\\\"Failed to invoke \\\"\",\"\\\" with no args\\\"\",\"null\",\"\\\"unchecked\\\"\",\"\\\"rawtypes\\\"\",\"0\",\"\\\"Invalid EnumSet type: \\\"\",\"\\\"Invalid EnumSet type: \\\"\",\"0\",\"null\",\"\\\"unchecked\\\"\",\"\\\"Unable to invoke no-args constructor for \\\"\",\"\\\". \\\"\",\"\\\"Register an InstanceCreator with Gson for this type may fix this problem.\\\"\"]}\n";
        String filePath = RESOURCES_DIR + "ConstructorConstructor.java";
        File file = new File(filePath);
        assertTrue("setup issue! couldn't load resources at " + filePath, file.exists());
        String[] array = new String[1];
        array[0] = file.getCanonicalPath();
        Launcher.main(array);
        String res = outContent.toString();
        assertFalse(res.isEmpty());
        assertEquals("Unexpected class parsing results.", expectedResult, res);
    }
}