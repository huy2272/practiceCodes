using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Inheritance
{
    //In C# class can only have 1 parent
    internal class Program
    {
        static void Main(string[] args)
        {
            var text = new Text();
            //Text class got the copy method through inheritance
            text.Copy();
        }
    }
}
