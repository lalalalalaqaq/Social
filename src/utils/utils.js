export function toggleElClass (el, className) {
  const elDom = document.querySelector(el)
  const reg = new RegExp('(\\s|^)' + className + '(\\s|$)')
  const hasClass = elDom.className.includes(reg)
  if (hasClass) {
    elDom.className = elDom.className.replace(reg, ' ')
  } else {
    elDom.classList.add(className)
  }
}
