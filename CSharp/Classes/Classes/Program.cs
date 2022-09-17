using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Classes
{
    public class Person
    {
        public string Name;

        public void Introduce(string to)
        {
            Console.WriteLine("Hi {0}, I am {1}", to, Name);
        }

        public static Person Parse(String str)
        {
            var person = new Person();
            person.Name = str;
            return person;
        }
    }
    internal class Program
    {
        static void Main(string[] args)
        {
            //Since we made the person method static, we don't have to make a person object
            var p = Person.Parse("John");
            p.Introduce("Tom");
        }
    }
}
