export const dateStringToDate = (dateString: string): Date => {
  const [day, month, year] = dateString
    .split('/')
    .map((str: string): number => parseInt(str))

  return new Date(year, month - 1, day)
}
