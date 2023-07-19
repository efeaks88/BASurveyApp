import logo from "../assets/images/logo.png";
import Accordion from "./Accordion";

function Sidebar() {
  // items sidebar'da gözükmesini istediğimiz liste
  // content kısmı ise label'a tıkladıktan sonra açılan listedeki content elemanları
  // href oluşturduğunuz sayfanın linki

  const items = [
    {
      label: "Kullanıcı İşlemleri",
      content: [
        { name: "Tüm Kullanıcılar", href: "/code" },
        {
          name: "Kullanıcı Ekle",
          href: "/",
        },
        {
          name: "Kullanıcı Düzenle",
          href: "",
        },
      ],
    },
    {
      label: "Anket İşlemleri",
      content: [
        { name: "Tüm Anketler", href: "/" },
        { name: "Anket Ekle", href: "/" },
        { name: "Anket Düzenle", href: "/" },
      ],
    },
    {
      label: "Soru İşlemleri",
      content: [
        { name: "Soruları Listele", href: "" },
        { name: "Soru Ekle", href: "" },
        { name: "Soru Etiketi İşlemleri", href: "" },
        { name: "Soru Tipi İşlemleri", href: "/" },
      ],
    },
    {
      label: "Sınıf İşlemleri",
      content: [
        { name: "Öğrenci Listleme", href: "/" },
        { name: "Eğitmen Listeleme", href: "/" },
        { name: "Sınıf Etiketi Oluşturma", href: "/" },
        { name: "Sınıfa Eğitmen Atama", href: "/" },
        { name: "Sınıfa Öğrenci Atama", href: "/" },
      ],
    },
    {
      label: "Raporlama",
      content: [
        { name: "Sonuçlanmış Anketler", href: "/" },
        { name: "Sınıfa Göre Anket Sonuçları", href: "/" },
        { name: "Kişiye Göre Anket Sonuçları", href: "/" },
      ],
    },
    {
      label: "Etiket İşlemleri",
      content: [
        { name: "Etiket Ekle", href: "/" },
        { name: "Etiket Güncelle", href: "/" },
        { name: "Etiket Silme", href: "/" },
      ],
    },
  ];

  return (
    <div className="flex flex-col gap-4 flex-[1_1_0%] bg-firstColor pl-4 pr-4   ">
      <div>
        <img src={logo} alt="" />
      </div>
      <Accordion items={items} />
    </div>
  );
}

export default Sidebar;