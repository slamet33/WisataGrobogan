package co.id.iu33.android.wisatagrobogan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * Created by Server on 26/07/2017.
 */

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerViewHolder> {

        //public TextView tv3;
    //deklarasi variable context

    private final Context context;
    // menampilkan list item dalam bentuk text dengan tipe dazta string dengan variable name
    String [] name={"Jati Pohon","Air Terjun Widuri","Api Abadi Mrapen","Danau Resto",
            "Taman Kota Purwodadi"};
    int thumb []= {R.drawable.abc,R.drawable.abcd,R.drawable.abcde,R.drawable.abcdef,
            R.drawable.abcdefg};
    String[] desk = {"Jatipohon merupakan suatu wilayah pedesaan yang terletak di kecamatan Grobogan, Kabupaten Grobogan, Jawa Tengah.Desa yang terletak di bagian utara kabupaten grobogan ini merupakan suatau daerah pegunungan yang berbatasan langsung dengan Kecamatan Sukolilo, Kabupaten Pati, Jawa Tengah.\n" +
            "\n" +
            "Dikarenakan merupakan suatu daerah pegunungan, mungkin yang menjadikan Jatipohon ini mempunyai hawa dan udara yang sejuk bila dibandingkan dengan beberapa wilayah lain di Kabupaten Grobogan.Dan hal ini pula yang mungkin menjadikan beberapa obyek wisata yang ada di Jatipohon pun berhubungan dengan pegunungan, seperti misalnya, sumber air, wisata hutan, wisata gua, dll.\n" +
            "\n" +
            "Saat perjalanan menuju ke Desa Olele sendiri, para penelusur akan menyusuri jalanan yang berkelok – kelok serta melin" +
            "tasi perumahan penduduk. Selama perjalanan, para penelusur akan disuguhi oleh dua pemandangan yang cukup kontras yaitu di" +
            "satu sisi para penelusur akan disuguhi pemandangan tebing-tebing curam berpohon. Namun di sisi lainnya, para penelusur akan disuguhi " +
            "oleh pemandangan hambaran laut biru hijau tanpa batas membentang yang pastinya akan membuat para penelusur terkesima dibuatnya.",

            "Api abadi Mrapen adalah sebuah kompleks yang terletak di desa Manggarmas, kecamatan Godong, Kabupaten Grobogan, Jawa Tengah. Kawasan ini terletak di tepi jalan raya Purwodadi - Semarang, berjarak 26 km dari Kota Purwodadi. Kompleks api abadi Mrapen merupakan fenomena geologi alam berupa keluarnya gas alam dari dalam tanah yang tersulut api sehingga menciptakan api yang tidak pernah padam walaupun turun hujan sekalipun.\n" +
                    "\n" +
                    "Banyak peristiwa besar mengambil api dari kompleks api abadi Mrapen sebagai sumber obornya, misalnya pesta olahraga internasional Ganefo I tanggal 1 November 1963. Api abadi dari Mrapen juga digunakan untuk menyalakan obor Pekan Olahraga Nasional (PON) mulai PON X tahun 1981, POR PWI tahun 1983 dan HAORNAS. Api abadi dari Mrapen juga digunakan untuk obor upacara hari raya Waisak.\n" +
                    "\n" +
                    "Selain api abadi, di komplek tersebut juga terdapat kolam dengan air mendidih yang konon dapat dipergunakan untuk mengobati penyakit kulit, serta batu bobot yang konon apabila seseorang dapat mengangkatnya maka yang mengangkat tersebut akan mendapatkan keinginannya." +
                            "menikmati pantai yang bisa untuk berenang serta menikmati sunset, pilihannya ya kesini.",

                    "Panorama keindahan alam Air Terjun Widuri yang sangat menarik untuk dikunjungi saat liburan, pesonanya yang masih terlihat alami ini memberikan daya tarik tersendiri bagi para pengunjung, terlebih dengan mitos-mitosnya. Wana wisata air terjun widuri tersebut sangat ramai dikunjungi oleh wisatawan lokal maupun luar kota dihari sabtu dan minggu. Secara grafis air terjun widuri tersebut di apit oleh gunung kendeng bagian selatan dan pegunungan gendeng utara batas wilayah kabupaten grobogan, yaitu perbatasan Pati selatan dengan Grobogan utara.\n" +
                            "\n" +
                            "Lokasi terletak di tengah kawasan hutan jati Desa Kemaduh Batur, Kecamatan Tawangharjo, Aksesbilitas berjarak kurang lebih 21 km sebelah timur laut kota Purwodadi di jalan raya Purwodadi Blora km 17. Kabupaten Grobogan, Air terjun widuri memiliki tinggi kurang lebih 50 meter. Hingga sampai sekarang Wana wisata air terjun widuri tersebut masih berkembang, yang pembangunannya dikelola oleh swadaya masyarakat dan akses jalannya di bangun PNPM Mandiri serta LH (lingkungan hidup), disamping wisata tersebut sangat berpotensi, juga terlihat memajukan desa yang tertinggal, dan sangat membantu bagi para pecinta alam untuk menikmati suasna tersebut, dan pencari ispirasi, karana wisata tersebut adalah salah satu wisata yang sangat berkembang kususnya di kabupaten Grobogan. Mesti agak berbukit turun naik jika ingin ketempat lokasi air terjun, " +
                            "namun hawanya sangat sejuk dan bisa melihat pemandangan yang indah disekitarnya. Tak hanya panoramannya yang sangat menarik dan indah, selain itu pemandian air terjun tersebut dipercayai warga setempat dan warga luar daerah bisa sebagai pelantara atau sarana pennyembuhan penyakit kulit di hari tertentu, jika mandi ditempat itu.",

            "Taman Hijau Kota Purwodadi (selanjutnya disebut dengan Taman Kota Purwodadi) merupakan wahana baru sebagai jujugan rekreasi keluarga yang gratis dan menyenangkan di pusat Kota Purwodadi, Kabupaten Grobogan. Taman Kota Purwodadi dibangun sebagai " +
                    "implementasi amanat Undang Undang (UU) Nomor 26 Tahun 2007 tentang penataan ruang yang mensyaratkan ruang terbuka hijau pada wilayah kota paling sedikit 30 persen dari luas wilayah kota. Dibangunnya Taman Kota Purwodadi membawa berkah tersendiri, karena kini ia menjadi jujugan favorit para kawula muda dan keluarga sebagai tempat jalan-jalan santai dan berselfi ria. Terutama pada hari Sabtu dan Minggu, Taman Kota Purwodadi ramai dipadati pengunjung.\n" +
                    "\n" +
                    "Lokasi Taman Kota Purwodadi  berada di Jl. Dr. Soetomo, yakni simpang lima ke arah timur atau belakang Rumah Sakit Islam (RSI). " +
                    "Berada di pusat kota Purwodadi menjadikan akses menuju lokasi sangat mudah dijangkau. Taman Kota Purwodadi dibangun di areal lahan seluas 3,2 ha. Selain berfungsi sebagai ruang terbuka hijau, juga dilengkapi berbagai fasilitas yang membuat asyik bersantai ria di taman ini. Antara lain: sport centre, gazebo, trek joging, taman, dan area bermain anak. Adapun tulisan besar Taman Hijau Kota Purwodadi menjadi spot paling diminati untuk selfie…\n" +
                    "\n" +
                    "Biasanya pengunjung Taman Kota Purwodadi memilih berkunjung pada sore dan malam hari, " +
                    "karena bila siang hari taman terasa panas oleh terik matahari. Bila sore dan malam hari, selain suasana adem, juga Taman Kota Purwodadi konon akan terlihat lebih indah dengan semburat lampu-lampu yang cantik.",
                    " Wisata Grobogan menyuguhkan daya tarik sebuah danau buatan berbentuk hati bernama Danau Resto. Danau buatan ini memang tak begitu luas, namun menyuguhkan pemandangan yang indah bagi pengunjung." +
                            "Danau Resto yang sejatinya adalah restoran ini terletak di Jl. Gajahmada Kuripan, Purwodadi, Kabupaten Grobogan, Jawa Tengah (Jateng). Seperti dikutip Semarangpos.com dari Direktorigrobogan.com, Danau Resto baru dibuka pada April 2016 lalu. Peresmian Danau Resto juga dihadiri Bupati Grobogan Sri Sumarni.\n" +
                            "\n" +
                            "Selain menyajikan pemandangan yang indah, Danau Resto juga menyuguhkan berbagai fasilitas seperti water park, rumah baca, kolam ikan hiu, dan bioskop tiga dimensi (3D). Selain itu, di Danau Resto juga terdapat pesawat Boeing 737 asli yang difungsikan sebagai sarana edukasi. Di dalam pesawat itu juga terdapat simulator pengoperasian pesawat.\n" +
                            "\n" +
                            "Bagi kawula muda, tentunya tempat ini menjadi destinasi kencan yang pas. Danau berbentuk hati akan menambah suasana romantis ketika kencan sembari menikmati pemandangan yang indah.\n" +
                            "\n" +
                            "Danau Resto ini juga sedang hangat diperbincangkan di grup Facebook Paguyuban Warga Purwodadi Grobogan. Publik pengguna Internet (netizen) mengungkapkan bahwa Danau Resto adalah rumah makan yang bisa juga dijadikan destinasi wisata. Tiket yang masuk yang murah membuat para masyarakat Grobogan gemar mengunjungi tempat tersebut.\n" +
                            "\n" +
                            "Harga tiket masuk Danau Resto adalah Rp.75.000 untuk 20 orang. Tiket itu adalah tiket paket yang juga termasuk tiket untuk memasuki beberapa wahana dan fasilitas yang ada di dalam Danau Resto.",
    };



    LayoutInflater inflater;
    public RecyclerAdapter(Context context) {
        this.context=context;
        inflater= LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_list, parent, false);

        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tv1.setText(name[position]);
        // holder.tv3.setText(desk[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.imageView.setImageResource(thumb[position]);
        holder.imageView.setOnClickListener(clickListener);
        //holder.tv3.setTag(holder);
        holder.tv1.setTag(holder);
        holder.imageView.setTag(holder);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//member aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            int position = vholder.getPosition();

            Toast.makeText(context, "Menu ini berada di posisi " + position, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, DetailWisata.class);
            intent.putExtra("judul", vholder.tv1.getText().toString());
            intent.putExtra("desk",desk[position]);

            context.startActivity(intent);

            Log.e(TAG,"kondisi bekerja");
        }
    };

    @Override
    public int getItemCount() {
        return name.length;
    }
}