import model.vo.ProductoVo;
import util.ListaCircularDoblementeEnlazada;

public class Test {
    public static void main(String[] args) {
        ListaCircularDoblementeEnlazada<ProductoVo> test = new ListaCircularDoblementeEnlazada<ProductoVo>();
        ProductoVo producto1 = new ProductoVo();
        producto1.setCodigo(1);
        producto1.setNombre("a");
        producto1.setValor(1d);
        producto1.setCantidad(1);
        
        ProductoVo producto2 = new ProductoVo();
        producto2.setCodigo(2);
        producto2.setNombre("b");
        producto2.setValor(2d);
        producto2.setCantidad(2);

        ProductoVo producto3 = new ProductoVo();
        producto3.setCodigo(3);
        producto3.setNombre("c");
        producto3.setValor(3d);
        producto3.setCantidad(3);

        test.agregarNodo(producto1);
        test.agregarNodo(producto2);
        test.agregarNodo(producto3);
        
        System.out.println(test);
        System.out.println(test.findNodoByIndex(0).getDato());
        System.out.println(test.findNodoByIndex(1).getDato());
        System.out.println(test.findNodoByIndex(2).getDato());
    }
}
