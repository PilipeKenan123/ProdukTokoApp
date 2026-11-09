package kelas.data;

import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Produk;

public class DataProduk {

    private final ObservableList<Produk> daftar = FXCollections.observableArrayList();
    private int urutan = 1;

    public ObservableList<Produk> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public Produk tambah(String nama, String kategori, long harga) {
        // PR%03d membuat kode produk: PR001, PR002, dan seterusnya.
        Produk p = new Produk(String.format("PR%03d", urutan), nama, kategori, harga);
        daftar.add(p);
        urutan++;
        return p;
    }

    public void hapus(Produk p) {
        daftar.remove(p);
    }

    public ObservableList<Produk> cariNama(String kata) {
        ObservableList<Produk> hasil = FXCollections.observableArrayList();
        String kunci = kata.trim().toLowerCase(Locale.ROOT);
        for (Produk p : daftar) {
            if (p.getNama().toLowerCase(Locale.ROOT).contains(kunci)) {
                hasil.add(p);
            }
        }
        return hasil;
    }
}
