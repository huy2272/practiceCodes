namespace stringMethods;

class StringMethods
{
    static void Main(string[] args)
    {
        var fullname = "Huy Nguyen";
        Console.WriteLine("Trim: '{0}'", fullname.ToUpper().Trim());

        var index = fullname.IndexOf(' ');
        var first = fullname.Substring(0, index);
        var last = fullname.Substring(index + 1);

        Console.WriteLine("firstname: " + first);
        Console.WriteLine("lastname: " + last);

        var names = fullname.Split(' ');
        Console.WriteLine("Firstname: " + names[0]);
        Console.WriteLine("Lastname: " + names[1]);

        var newName = fullname.Replace("Nguyen", "Tang");
        Console.WriteLine("New name: " + newName);

        if (string.IsNullOrEmpty(" ".Trim()))
            Console.WriteLine("Invalid");
        float price = 29.95f;
        Console.WriteLine(price.ToString("C0"));
    }

}