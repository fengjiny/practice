package book.java_concurrency_in_practice;


public class ResourceFactory {
    private static class ResourceHolder{
        public static Resource resource = new Resource();
    }

    public static Resource getResource(){
        return ResourceHolder.resource;
    }
}
