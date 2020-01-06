package tienda.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tienda.dao.AlbumDAO;
import tienda.en.AlbumEN;


@Stateless
public class AlbumON {

	@Inject
	private AlbumDAO albumDAO;
	

	public void guardar(AlbumEN album) {
		List<AlbumEN> productodos= null;
		productodos= (List<AlbumEN>) albumDAO.getArtista(album.getDescripcion());
		System.out.println(productodos.size()+"pppppppppppppppppppp");
		
		if(productodos.size()==0) {
			albumDAO.insertar(album);
			System.out.println("no existe ");
		}else {
			
			System.out.println(" update");
		}
		
		

		
	}

	public List<AlbumEN> obtenerListaProducto() {
		return albumDAO.obtenerAlbum();
	}

//	public void eliminar(int id) throws Exception {
//		try {
//			albumDAO.borrar(id);
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new Exception("error" + e.getMessage());
//		}
//	}

	public List<AlbumEN> editar(AlbumEN album) {



		albumDAO.actualizar(album);

		return albumDAO.obtenerAlbum();
	}

	public List<AlbumEN> listarPorNombre(String nombre) {

		return albumDAO.getArtista(nombre);

	}
	
	public AlbumEN artista(String nombre) {
		//System.out.println("buscar..............."+nombre);
		//AlbumEN albumdos=albumDAO.getNombreArtista(nombre);
		//System.out.println(albumdos.getDescripcion()+"res busqueda");
		
		return albumDAO.getNombreArtista(nombre);
		
	}

}
