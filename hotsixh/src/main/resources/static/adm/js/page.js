goList = function (thisPage) {
    document.querySelector("input[name=thisPage]").value = thisPage;
    form.action = goUrlUsrList;
    form.submit();
}