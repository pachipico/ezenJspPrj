const deleteBtn = document.getElementById("deleteBtn");
const modForm = document.getElementById("modForm");
deleteBtn.addEventListener("click", (e) => {
  e.preventDefault();
  modForm.setAttribute("action", "/prodCtrl/remove");
  modForm.submit();
});
