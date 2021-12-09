const resignBtn = document.getElementById("resignBtn");
const modForm = document.getElementById("modForm");

resignBtn.addEventListener("click", (e) => {
  e.preventDefault();
  console.log("dsaf");
  modForm.setAttribute("action", "/memCtrl/remove");
  modForm.submit();
});
